package br.com.gabrielmarcos.coroutines_sunflower.di.view

import br.com.gabrielmarcos.coroutines_sunflower.weather.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}