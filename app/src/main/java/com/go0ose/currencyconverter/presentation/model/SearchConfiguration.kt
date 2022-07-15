package com.go0ose.currencyconverter.presentation.model

data class SearchConfiguration(
    var sort: Sort = Sort.AlphabetAscending,
    var base: String = "USD"
)

sealed class Sort {
    object AlphabetAscending : Sort()
    object AlphabetDescending : Sort()
    object ValueAscending : Sort()
    object ValueDescending : Sort()
}