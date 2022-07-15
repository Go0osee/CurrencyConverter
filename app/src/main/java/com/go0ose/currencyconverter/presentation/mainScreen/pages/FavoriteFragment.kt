package com.go0ose.currencyconverter.presentation.mainScreen.pages

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.go0ose.currencyconverter.CurrencyApplication
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.databinding.FragmentFavoriteBinding
import com.go0ose.currencyconverter.presentation.mainScreen.MainViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.recycler.ClickListener
import com.go0ose.currencyconverter.presentation.mainScreen.recycler.CurrencyAdapter
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.TypeItems
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding: FragmentFavoriteBinding by viewBinding()

    private val mainViewModel: MainViewModel by activityViewModels()

    @Inject
    lateinit var favoriteViewModel: FavoriteViewModel

    private val adapter by lazy { CurrencyAdapter(onItemClickListener) }

    private val onItemClickListener by lazy {
        object : ClickListener {
            override fun onItemClick(item: Rate) {
                mainViewModel.setBaseCurrency(item)
            }

            override fun onImageClick(item: Rate) {
                favoriteViewModel.deleteCurrencyFromFavorite(item)
                Toast.makeText(requireContext(), getString(R.string.deleted), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CurrencyApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerFavorite.adapter = adapter
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenCreated {
            mainViewModel.listRatesStateFlow.collectLatest { listRates ->
                favoriteViewModel.listAllRates = listRates
                favoriteViewModel.setFavoriteList()
            }
        }
        lifecycleScope.launchWhenCreated {
            favoriteViewModel.sortedFavoriteCurrencyStateFlow.collectLatest { listRates ->
                adapter.submitList(listRates, TypeItems.Favourite)
            }
        }
        lifecycleScope.launchWhenCreated {
            mainViewModel.listBaseStr.collectLatest { listBaseStr ->
                favoriteViewModel.setListAllBaseStrStateFlow(listBaseStr)
                favoriteViewModel.setFavoriteList()
            }
        }
        lifecycleScope.launchWhenCreated {
            favoriteViewModel.listAllBaseStrStateFlow.collectLatest { listString ->
                mainViewModel.setListAllBaseStrStateFlow(listString)
            }
        }
    }
}