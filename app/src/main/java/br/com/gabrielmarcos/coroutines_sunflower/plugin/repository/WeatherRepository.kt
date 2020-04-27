package br.com.gabrielmarcos.coroutines_sunflower.plugin.repository

import androidx.lifecycle.MutableLiveData
import br.com.gabrielmarcos.coroutines_sunflower.core.Result
import br.com.gabrielmarcos.coroutines_sunflower.model.Forecasts
import br.com.gabrielmarcos.coroutines_sunflower.model.SearchSuggestion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val remoteSource: RemoteDataSource
) {

    //TODO review resultLiveData

    fun searchLocality(
        search: String,
        ioCoroutineScope: CoroutineScope,
        liveData: MutableLiveData<Result<List<SearchSuggestion>>>
    ) {
        ioCoroutineScope.launch {
            liveData.postValue(Result.loading())
            liveData.postValue(remoteSource.searchLocalities(search))
        }
    }

    fun getForecasts(
        key: String,
        ioCoroutineScope: CoroutineScope,
        liveData: MutableLiveData<Result<Forecasts>>
    ) {
        ioCoroutineScope.launch {
            liveData.postValue(Result.loading())
            liveData.postValue(remoteSource.getForecasts(key))
        }
    }
}
