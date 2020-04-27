package br.com.gabrielmarcos.coroutines_sunflower.weather

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gabrielmarcos.coroutines_sunflower.R
import br.com.gabrielmarcos.coroutines_sunflower.base.BaseActivity
import br.com.gabrielmarcos.coroutines_sunflower.core.Result.Status.ERROR
import br.com.gabrielmarcos.coroutines_sunflower.core.Result.Status.LOADING
import br.com.gabrielmarcos.coroutines_sunflower.core.Result.Status.SUCCESS
import br.com.gabrielmarcos.coroutines_sunflower.di.viewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), SuggestionAdapter.OnSuggestionListener {

    private lateinit var viewModel: WeatherViewModel

    private var suggestionAdapter = SuggestionAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()
        setUpView()
        setUpViewModel()
        setUpObservables()
    }

    private fun setUpViewModel() {
        viewModel = viewModelProvider(viewModelFactory)
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setUpView() {
        suggestionLocalities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = suggestionAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(quest: String?): Boolean {
                viewModel.getSuggestion(quest ?: "")
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun setUpObservables() {
        viewModel.suggestion.observe(this, Observer { response ->
            when (response.status) {
                SUCCESS -> {
                    progress.visibility = View.GONE
                    suggestionLocalities.visibility = View.VISIBLE
                    suggestionAdapter.setData(response.data!!)
                }
                LOADING -> {
                    progress.visibility = View.VISIBLE
                    suggestionLocalities.visibility = View.INVISIBLE
                }
                ERROR -> {
                    progress.visibility = View.GONE
                    suggestionLocalities.visibility = View.INVISIBLE
                }
            }
        })

        viewModel.forecast.observe(this, Observer { response ->
            when (response.status) {
                SUCCESS -> progress.visibility = View.GONE
                LOADING -> Toast.makeText(this, "Carregando", Toast.LENGTH_LONG).show()
                ERROR -> Toast.makeText(this, response.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onSelectedItem(key: String) {
        print(key)
    }
}
