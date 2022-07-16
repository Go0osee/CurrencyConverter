package com.go0ose.currencyconverter

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.go0ose.currencyconverter.data.di.DataModule
import com.go0ose.currencyconverter.data.di.RetrofitModule
import com.go0ose.currencyconverter.data.di.RoomModule
import com.go0ose.currencyconverter.domain.di.DomainModule
import com.go0ose.currencyconverter.presentation.di.SharedViewModelModule
import com.go0ose.currencyconverter.presentation.mainScreen.MainActivity
import com.go0ose.currencyconverter.presentation.di.ViewModelModule
import com.go0ose.currencyconverter.presentation.mainScreen.MainFragment
import com.go0ose.currencyconverter.presentation.mainScreen.pages.FavoriteFragment
import com.go0ose.currencyconverter.presentation.mainScreen.pages.PopularFragment
import com.go0ose.currencyconverter.presentation.di.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DomainModule::class,
        RetrofitModule::class,
        RoomModule::class,
        DataModule::class,
        ViewModelModule::class,
        SharedViewModelModule::class
    ]
)
interface AppComponent {

    fun viewModelsFactory(): ViewModelFactory
    fun inject(target: MainActivity)
    fun inject(target: PopularFragment)
    fun inject(target: FavoriteFragment)
    fun inject(target: MainFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun viewStore(viewModelStoreOwner: ViewModelStoreOwner): Builder

        @BindsInstance
        fun buildContext(context: Context): Builder

        fun build(): AppComponent
    }
}