package br.com.gabrielmarcos.coroutines_sunflower.plugin.repository

import br.com.gabrielmarcos.coroutines_sunflower.core.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(private val remoteSource: RemoteDataSource) {

    val suggestions = resultLiveData(
        // databaseQuery = { dao.getLegoThemes() },
        networkCall = { remoteSource.fetchData() }
        // saveCallResult = { dao.insertAll(it.results) }
    )
}
