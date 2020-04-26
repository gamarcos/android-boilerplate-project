package br.com.gabrielmarcos.coroutines_sunflower.plugin.repository

import br.com.gabrielmarcos.coroutines_sunflower.plugin.service.WeatherService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: WeatherService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getAutocompleteSuggestions() }

}