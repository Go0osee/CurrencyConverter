package com.go0ose.currencyconverter.presentation.model

sealed class TypeItems {
    object Popular : TypeItems()
    object Favourite : TypeItems()
}