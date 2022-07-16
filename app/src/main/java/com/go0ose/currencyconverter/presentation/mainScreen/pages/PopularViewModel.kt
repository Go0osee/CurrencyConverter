package com.go0ose.currencyconverter.presentation.mainScreen.pages

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.domain.CurrencyInteractor
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.SearchConfiguration
import com.go0ose.currencyconverter.utils.sorting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularViewModel @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : ViewModel() {

    private val _sortedPopularCurrencyStateFlow = MutableStateFlow<List<Rate>>(emptyList())
    val sortedPopularCurrencyStateFlow: StateFlow<List<Rate>> = _sortedPopularCurrencyStateFlow

    private val _listBaseStr = MutableStateFlow<List<String>>(emptyList())
    val listBaseStr: StateFlow<List<String>> = _listBaseStr

    init {
        initFlow()
    }

    private fun initFlow() {
        currencyInteractor.getSavedCurrency()
            .map { listBaseStr ->
                _listBaseStr.value = listBaseStr
            }
            .launchIn(viewModelScope)
    }

    fun loadCurrency(searchConfiguration: SearchConfiguration) {
        viewModelScope.launch {
            _sortedPopularCurrencyStateFlow.value =
                currencyInteractor.getCurrencyResponse(searchConfiguration.base).rates.sorting(
                    searchConfiguration.sort
                )
        }
    }

    fun addCurrencyToFavorite(item: Rate, context: Context, function: (String) -> Unit) {
        viewModelScope.launch {
            _listBaseStr.value.forEach {
                if(it == item.name){
                    function(context.getString(R.string.already_added_to_your_favorites))
                    return@launch
                }
            }
            function(context.getString(R.string.added))
            currencyInteractor.saveCurrency(item)
        }
    }

    fun setListAllBaseStrStateFlow(listString: List<String>) {
        _listBaseStr.value = listString
    }
}