package br.com.gabrielmarcos.coroutines_sunflower.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Forecasts(
    @SerializedName("Headline") val headline : Headline?,
    @SerializedName("DailyForecasts") val dailyForecasts : List<DailyForecasts>?
) : Serializable