package br.com.gabrielmarcos.coroutines_sunflower

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.gabrielmarcos.coroutines_sunflower.base.BaseActivity
import br.com.gabrielmarcos.coroutines_sunflower.di.viewModelProvider

class MainActivity : BaseActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = viewModelProvider(viewModelFactory)

        viewModel.suggestions.observe(this, Observer {
            Toast.makeText(this, it.data?.get(0)?.localizedName, Toast.LENGTH_LONG).show()
        })

    }
}
