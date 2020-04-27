package br.com.gabrielmarcos.coroutines_sunflower.base

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import br.com.gabrielmarcos.coroutines_sunflower.core.Event
import br.com.gabrielmarcos.coroutines_sunflower.core.EventObserver
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    fun setUpSnackbar(view: View, snackbarMessage: LiveData<Event<String>>) {
        snackbarMessage.observe(viewLifecycleOwner, EventObserver {
            Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        })
    }
}