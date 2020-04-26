package br.com.gabrielmarcos.coroutines_sunflower.di

import br.com.gabrielmarcos.coroutines_sunflower.plugin.service.WeatherService
import br.com.gabrielmarcos.coroutines_sunflower.plugin.service.WeatherService.Companion.BASE_URL
import br.com.gabrielmarcos.coroutines_sunflower.di.qualifiers.CoroutineScropeIO
import br.com.gabrielmarcos.coroutines_sunflower.di.qualifiers.WeatherAPI
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideWeatherService(
        @WeatherAPI okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, WeatherService::class.java)

    // @Singleton
    // @Provides
    // fun provideGistRepositoryImpl(gitService: GitService,
    //     gistDAO: GistDAO, favoritesDAO: FavoritesDAO) = GistRepositoryImpl(gitService, gistDAO, favoritesDAO)

    @WeatherAPI
    @Provides
    fun providePrivateOkHttpClient(
        upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder().build()
    }

    // @Singleton
    // @Provides
    // fun provideDb(app: Application) = AppDatabase.getInstance(app)

    // @Singleton
    // @Provides
    // fun provideRecentSearches(db: AppDatabase) = db.repositoryDAO()
    //
    // @Singleton
    // @Provides
    // fun provideFavoriteDAO(db: AppDatabase) = db.favoritesDAO()

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)

    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory,
        clazz: Class<T>
    ): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}
