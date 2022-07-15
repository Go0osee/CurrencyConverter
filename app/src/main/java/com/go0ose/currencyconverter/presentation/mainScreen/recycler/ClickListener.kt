package com.go0ose.currencyconverter.presentation.mainScreen.recycler

import com.go0ose.currencyconverter.presentation.model.Rate

interface ClickListener {

    fun onItemClick(item: Rate)

    fun onImageClick(item: Rate)
}