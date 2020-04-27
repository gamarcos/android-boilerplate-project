package br.com.gabrielmarcos.coroutines_sunflower.plugin.repository

import br.com.gabrielmarcos.coroutines_sunflower.plugin.service.WeatherService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: WeatherService) : BaseDataSource() {

    suspend fun searchLocalities(search: String) = getResult { service.getAutocompleteSuggestions(search = search) }

    suspend fun getForecasts(key: String) = getResult { service.getForecasts(locationsKey = key) }

}