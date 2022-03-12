package com.hassanmohammed.currencyapp.ui.fragments.historical

import com.hassanmohammed.currencyapp.domain.models.HistoricalRate

data class HistoricalRatesUiState(
    val data: List<HistoricalRate>? = emptyList(),
    val isLoading: Boolean = false
)