package com.go0ose.currencyconverter.presentation.mainScreen.pages

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.go0ose.currencyconverter.CurrencyApplication
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.databinding.FragmentPopularBinding
import com.go0ose.currencyconverter.presentation.mainScreen.SharedViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.recycler.ClickListener
import com.go0ose.currencyconverter.presentation.mainScreen.recycler.CurrencyAdapter
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.TypeItems
import com.go0ose.currencyconverter.utils.appComponent
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class PopularFragment : Fragment(R.layout.fragment_popular) {

    private val binding: FragmentPopularBinding by viewBinding()

    @Inject
    lateinit var sharedViewModel: SharedViewModel

    private val popularViewModel: PopularViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val adapter by lazy { CurrencyAdapter(onItemClickListener) }

    private val onItemClickListener by lazy {
        object : ClickListener {
            override fun onItemClick(item: Rate) {
                sharedViewModel.setBaseCurrency(item)
            }

            override fun onImageClick(item: Rate) {
                popularViewModel.addCurrencyToFavorite(item, requireContext()) { message ->
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CurrencyApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerPopular.adapter = adapter
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenCreated {
            sharedViewModel.searchConfigurationStateFlow.collectLatest { searchConfiguration ->
                popularViewModel.loadCurrency(searchConfiguration)
            }
        }
        lifecycleScope.launchWhenCreated {
            popularViewModel.sortedPopularCurrencyStateFlow.collectLatest { listCurrency ->
                sharedViewModel.setCurrency(listCurrency)
                adapter.submitList(listCurrency, TypeItems.Popular)
            }
        }
        lifecycleScope.launchWhenCreated {
            popularViewModel.listBaseStr.collectLatest { listBaseStr ->
                sharedViewModel.setBaseStr(listBaseStr)
            }
        }
        lifecycleScope.launchWhenCreated {
            sharedViewModel.listAllBaseStrStateFlow.collectLatest { listString ->
                popularViewModel.setListAllBaseStrStateFlow(listString)
            }
        }
    }
}