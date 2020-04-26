package br.com.gabrielmarcos.coroutines_sunflower

import androidx.lifecycle.ViewModel
import br.com.gabrielmarcos.coroutines_sunflower.plugin.repository.WeatherRepository
import javax.inject.Inject

class WeatherViewModel @Inject constructor(repository: WeatherRepository) : ViewModel() {

    val suggestions = repository.suggestions
}