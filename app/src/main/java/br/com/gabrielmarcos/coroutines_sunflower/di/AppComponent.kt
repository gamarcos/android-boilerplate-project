package br.com.gabrielmarcos.coroutines_sunflower.di

import android.app.Application
import br.com.gabrielmarcos.coroutines_sunflower.App
import br.com.gabrielmarcos.coroutines_sunflower.di.view.ActivityModule
import br.com.gabrielmarcos.coroutines_sunflower.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        AppModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}