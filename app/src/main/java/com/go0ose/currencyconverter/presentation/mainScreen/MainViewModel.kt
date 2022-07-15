package com.go0ose.currencyconverter.presentation.mainScreen

import androidx.lifecycle.ViewModel
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.SearchConfiguration
import com.go0ose.currencyconverter.presentation.model.Sort
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _searchConfigurationStateFlow = MutableStateFlow<SearchConfiguration>(SearchConfiguration())
    val searchConfigurationStateFlow: StateFlow<SearchConfiguration> = _searchConfigurationStateFlow

    private val _listRatesStateFlow = MutableStateFlow<List<Rate>>(emptyList())
    val listRatesStateFlow: StateFlow<List<Rate>> = _listRatesStateFlow

    private val _listBaseStr = MutableStateFlow<List<String>>(emptyList())
    val listBaseStr: StateFlow<List<String>> = _listBaseStr

    private val _listAllBaseStrStateFlow = MutableStateFlow<List<String>>(emptyList())
    val listAllBaseStrStateFlow: StateFlow<List<String>> = _listAllBaseStrStateFlow


    fun sortImageClicked(sort: Sort) {
        _searchConfigurationStateFlow.value = SearchConfiguration(sort, _searchConfigurationStateFlow.value.base)
    }

    fun setBaseCurrency(item: Rate) {
        _searchConfigurationStateFlow.value = SearchConfiguration(_searchConfigurationStateFlow.value.sort, item.name)
    }

    fun setCurrency(listCurrency: List<Rate>) {
        _listRatesStateFlow.value = listCurrency
    }

    fun setBaseStr(listBaseStr: List<String>) {
        _listBaseStr.value = listBaseStr
    }

    fun setListAllBaseStrStateFlow(listString: List<String>) {
        _listAllBaseStrStateFlow.value = listString
    }
}