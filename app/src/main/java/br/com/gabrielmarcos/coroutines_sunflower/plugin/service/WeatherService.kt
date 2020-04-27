package br.com.gabrielmarcos.coroutines_sunflower.plugin.service

import br.com.gabrielmarcos.coroutines_sunflower.model.Forecasts
import br.com.gabrielmarcos.coroutines_sunflower.model.SearchSuggestion
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    // TODO change to build.gradle
    companion object {
        val BASE_URL = "http://dataservice.accuweather.com/"
    }

    @GET("locations/v1/cities/autocomplete")
    suspend fun getAutocompleteSuggestions(
        @Query("apikey") key: String? = "6HIXWBpsdhvH0hYmZ9LNXrNLYIaidD0I",
        @Query("q") search: String? = "São Paulo"
    ): Response<List<SearchSuggestion>>

    @GET("forecasts/v1/daily/5day/{locationKey}")
    suspend fun getForecasts(
        @Path("locationKey") locationsKey: String? = "45449",
        @Query("apikey") key: String? = "6HIXWBpsdhvH0hYmZ9LNXrNLYIaidD0I"
    ): Response<Forecasts>
}