package com.hassanmohammed.currencyapp.data.remote.dto.historical

import com.hassanmohammed.currencyapp.domain.models.HistoricalRate


data class HistoricalRateDto(
    val success: Boolean? = false,
    val historical: Boolean? = false,
    val date: String? = "",
    val timestamp: Int? = 0,
    val base: String? = "",
    val rates: Map<String, Float>?,
    val error: FixerApiErrorDto? = null
) {
    fun toHistoricalRate() = HistoricalRate(date.orEmpty(), base.orEmpty(), rates?.values?.first(), error?.message)
}