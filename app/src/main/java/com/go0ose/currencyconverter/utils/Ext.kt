package com.go0ose.currencyconverter.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.go0ose.currencyconverter.AppComponent
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.presentation.mainScreen.MainActivity
import com.go0ose.currencyconverter.presentation.model.Sort

fun FragmentActivity.openFragment(container: Int, tag:String, fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .replace(container,fragment,tag)
        .addToBackStack(tag)
        .commit()
}

fun Fragment.showSortDialog(
    context: Context,
    onClick: (sort: Sort) -> Unit,
) {
    val builder = AlertDialog.Builder(context)
    val dialogLayout = layoutInflater.inflate(R.layout.dialog_alert, null)

    val alphabetAscending = dialogLayout.findViewById<TextView>(R.id.alphabeticallyAscending)
    val alphabetDescending = dialogLayout.findViewById<TextView>(R.id.alphabeticallyDescending)
    val valueAscending = dialogLayout.findViewById<TextView>(R.id.byValueAscending)
    val valueDescending = dialogLayout.findViewById<TextView>(R.id.byValueDescending)

    builder.setCancelable(false)
    builder.setView(dialogLayout)

    val alertDialog = builder.create()
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    alphabetAscending.setOnClickListener {
        it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_image_button))
        onClick(Sort.AlphabetAscending)
        alertDialog.cancel()
    }

    alphabetDescending.setOnClickListener {
        it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_image_button))
        onClick(Sort.AlphabetDescending)
        alertDialog.cancel()
    }

    valueAscending.setOnClickListener {
        it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_image_button))
        onClick(Sort.ValueAscending)
        alertDialog.cancel()
    }

    valueDescending.setOnClickListener {
        it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_image_button))
        onClick(Sort.ValueDescending)
        alertDialog.cancel()
    }

    alertDialog.show()
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainActivity -> appComponent
        else -> this.applicationContext.appComponent
    }