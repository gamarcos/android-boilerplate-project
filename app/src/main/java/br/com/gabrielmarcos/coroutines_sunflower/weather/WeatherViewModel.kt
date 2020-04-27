package br.com.gabrielmarcos.coroutines_sunflower.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.gabrielmarcos.coroutines_sunflower.core.Result
import br.com.gabrielmarcos.coroutines_sunflower.di.qualifiers.CoroutineScropeIO
import br.com.gabrielmarcos.coroutines_sunflower.model.Forecasts
import br.com.gabrielmarcos.coroutines_sunflower.model.SearchSuggestion
import br.com.gabrielmarcos.coroutines_sunflower.plugin.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {

    internal var suggestion: MutableLiveData<Result<List<SearchSuggestion>>> = MutableLiveData()

    internal var forecast: MutableLiveData<Result<Forecasts>> = MutableLiveData()

    fun getSuggestion(search: String) =
        repository.searchLocality(search, ioCoroutineScope, suggestion)

    fun getForecasts(key: String) =
        repository.getForecasts(key, ioCoroutineScope, forecast)
}