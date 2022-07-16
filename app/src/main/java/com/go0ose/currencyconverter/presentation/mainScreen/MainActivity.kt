package com.go0ose.currencyconverter.presentation.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.go0ose.currencyconverter.AppComponent
import com.go0ose.currencyconverter.CurrencyApplication
import com.go0ose.currencyconverter.DaggerAppComponent
import com.go0ose.currencyconverter.R
import com.go0ose.currencyconverter.utils.openFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SharedViewModel

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CurrencyApplication.initDagger(this, this)
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .viewStore(this)
            .build()
        CurrencyApplication.appComponent?.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(R.id.container, MainFragment.TAG, MainFragment.newInstance())
    }
}