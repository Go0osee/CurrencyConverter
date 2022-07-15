package com.go0ose.currencyconverter

import android.content.Context
import com.go0ose.currencyconverter.data.di.DataModule
import com.go0ose.currencyconverter.data.di.RoomModule
import com.go0ose.currencyconverter.domain.di.DomainModule
import com.go0ose.currencyconverter.presentation.mainScreen.MainActivity
import com.go0ose.currencyconverter.presentation.di.ViewModelModule
import com.go0ose.currencyconverter.presentation.mainScreen.pages.FavoriteFragment
import com.go0ose.currencyconverter.presentation.mainScreen.pages.PopularFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DomainModule::class,
        DataModule::class,
        RoomModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: PopularFragment)
    fun inject(target: FavoriteFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}