package com.go0ose.currencyconverter.presentation.mainScreen.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.TypeItems

class CurrencyAdapter(
    private val clickListener: ClickListener
) :
    RecyclerView.Adapter<CurrencyViewHolder>() {

    private var items: List<Rate> = emptyList()
    private var type: TypeItems = TypeItems.Popular

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder.newInstance(parent, clickListener)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bindItem(items[position], type)
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<Rate>, type: TypeItems) {
        notifyDataSetChanged()
        items = data
        this.type = type
    }
}
