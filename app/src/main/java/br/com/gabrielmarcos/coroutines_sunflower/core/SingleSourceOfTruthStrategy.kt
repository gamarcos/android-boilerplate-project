package br.com.gabrielmarcos.coroutines_sunflower.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import br.com.gabrielmarcos.coroutines_sunflower.core.Result.Status.SUCCESS
import kotlinx.coroutines.Dispatchers

/**
 * The database serves as the single source of truth.
 * Therefore UI can receive data updates from database only.
 * Function notify UI about:
 * [Result.Status.SUCCESS] - with data from database
 * [Result.Status.ERROR] - if error has occurred from any source
 * [Result.Status.LOADING]
 */
fun <T> resultLiveData(
    networkCall: suspend () -> Result<T>
): LiveData<Result<T>> = liveData(Dispatchers.Default) {
    emit(Result.loading())

    val responseStatus = networkCall.invoke()

    when (responseStatus.status) {
        SUCCESS -> emit(Result.success(responseStatus.data!!))
        else -> {
            emit(Result.error(responseStatus.message ?: ""))
        }
    }
}