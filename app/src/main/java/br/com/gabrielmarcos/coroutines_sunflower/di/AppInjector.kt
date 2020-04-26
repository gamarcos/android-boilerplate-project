package br.com.gabrielmarcos.coroutines_sunflower.di

import br.com.gabrielmarcos.coroutines_sunflower.App

object AppInjector {
    fun init(application: App) {
        DaggerAppComponent.builder().application(application)
            .build().inject(application)
    }
}