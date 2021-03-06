package com.hassanmohammed.currencyapp.di

import com.hassanmohammed.currencyapp.data.MainRepository
import com.hassanmohammed.currencyapp.data.MainRepositoryImpl
import com.hassanmohammed.currencyapp.data.remote.CurrencyService
import com.hassanmohammed.currencyapp.domain.interactors.currencyconverter.ConvertBaseCurrencyIntoMultipleCurrenciesInteractor
import com.hassanmohammed.currencyapp.domain.interactors.currencyconverter.ConvertBaseCurrencyIntoMultipleCurrenciesInteractorImpl
import com.hassanmohammed.currencyapp.domain.interactors.currencyconverter.ConvertCurrencyInteractor
import com.hassanmohammed.currencyapp.domain.interactors.currencyconverter.ConvertCurrencyInteractorImpl
import com.hassanmohammed.currencyapp.domain.interactors.historical.GetHistoricalRatesInteractorImpl
import com.hassanmohammed.currencyapp.domain.interactors.historical.GetHistoricalRatesIntercator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMainRepository(apiService: CurrencyService): MainRepository {
        return MainRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideHistoricalRatesIntercator(repository: MainRepository): GetHistoricalRatesIntercator {
        return GetHistoricalRatesInteractorImpl(repository)
    }

    @Singleton
    @Provides
    fun provideCurrencyConverterInteractor(repository: MainRepository): ConvertCurrencyInteractor {
        return ConvertCurrencyInteractorImpl(repository)
    }

    @Singleton
    @Provides
    fun provideBaseCurrencyConverterIntoMultipleCurrenciesInteractor(repository: MainRepository): ConvertBaseCurrencyIntoMultipleCurrenciesInteractor {
        return ConvertBaseCurrencyIntoMultipleCurrenciesInteractorImpl(repository)
    }
}