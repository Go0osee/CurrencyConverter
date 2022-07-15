package com.go0ose.currencyconverter.presentation.mainScreen.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.databinding.ItemCurrencyBinding
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.TypeItems

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding,
    private val clickListener: ClickListener
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            clickListener: ClickListener
        ) =
            CurrencyViewHolder(
                ItemCurrencyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), clickListener
            )
    }

    fun bindItem(item: Rate, type: TypeItems) {
        with(binding) {

            currencyName.text = item.name
            value.text = item.value

            when (type) {
                is TypeItems.Popular -> image.setImageResource(R.drawable.ic_favourite)
                is TypeItems.Favourite -> image.setImageResource(R.drawable.ic_delete)
            }

            root.setOnClickListener {
                it.startAnimation(
                    AnimationUtils.loadAnimation(itemView.context, R.anim.anim_image_button)
                )
                clickListener.onItemClick(item)
            }
            image.setOnClickListener {
                it.startAnimation(
                    AnimationUtils.loadAnimation(itemView.context, R.anim.anim_image_button)
                )
                clickListener.onImageClick(item)
            }
        }
    }
}