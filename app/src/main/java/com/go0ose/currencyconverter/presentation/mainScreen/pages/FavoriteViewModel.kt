package com.go0ose.currencyconverter.presentation.mainScreen.pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.go0ose.currencyconverter.domain.CurrencyInteractor
import com.go0ose.currencyconverter.presentation.model.Rate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val currencyInteractor: CurrencyInteractor
) : ViewModel() {

    private val _sortedFavoriteCurrencyStateFlow = MutableStateFlow<List<Rate>>(emptyList())
    val sortedFavoriteCurrencyStateFlow: StateFlow<List<Rate>> = _sortedFavoriteCurrencyStateFlow

    private val _listAllBaseStrStateFlow = MutableStateFlow<List<String>>(emptyList())
    val listAllBaseStrStateFlow: StateFlow<List<String>> = _listAllBaseStrStateFlow

    var listAllRates: List<Rate> = emptyList()

    init {
        initFlow()
    }

    private fun initFlow() {
        currencyInteractor.getSavedCurrency()
            .map { listBaseStr ->
                _listAllBaseStrStateFlow.value = listBaseStr
                val resultListRate: MutableList<Rate> = mutableListOf()

                listAllRates.forEach { rate ->
                    listBaseStr.forEach { rateBase ->
                        if (rate.name == rateBase) {
                            resultListRate.add(rate)
                        }
                    }
                }
                _sortedFavoriteCurrencyStateFlow.value = resultListRate
            }
            .launchIn(viewModelScope)
    }


    fun deleteCurrencyFromFavorite(item: Rate) {
        viewModelScope.launch {
            currencyInteractor.deleteCurrency(item)
        }
    }

    fun setFavoriteList() {
        viewModelScope.launch {
            val resultListRate: MutableList<Rate> = mutableListOf()

            listAllRates.forEach { rate ->
                _listAllBaseStrStateFlow.value.forEach { rateBase ->
                    if (rate.name == rateBase) {
                        resultListRate.add(rate)
                    }
                }
            }
            _sortedFavoriteCurrencyStateFlow.value = resultListRate
        }
    }

    fun setListAllBaseStrStateFlow(listBaseStr: List<String>) {
        _listAllBaseStrStateFlow.value = listBaseStr
    }
}
