package com.go0ose.currencyconverter.presentation.mainScreen

import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.databinding.FragmentMainBinding
import com.go0ose.currencyconverter.utils.showSortDialog
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    private val viewModel: MainViewModel by activityViewModels()

    companion object {
        const val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    override fun onStart() {
        super.onStart()
        initViewPager()
        initObserver()
        initViews()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = PageAdapter(requireActivity())
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> tab.text = getString(R.string.popular)
                1 -> tab.text = getString(R.string.favorite)
            }
        }.attach()
    }

    private fun initObserver() {
        lifecycleScope.launchWhenCreated {
            viewModel.searchConfigurationStateFlow.collectLatest { searchConfiguration ->
                binding.selectedCurrency.text =  searchConfiguration.base
            }
        }
    }

    private fun initViews() {
        binding.imageSort.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_image_button))
            showSortDialog(requireContext()) { sort ->
                viewModel.sortImageClicked(sort)
            }
        }
    }
}