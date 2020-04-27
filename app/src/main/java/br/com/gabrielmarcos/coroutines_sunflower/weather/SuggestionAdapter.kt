package br.com.gabrielmarcos.coroutines_sunflower.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrielmarcos.coroutines_sunflower.R
import br.com.gabrielmarcos.coroutines_sunflower.model.SearchSuggestion
import br.com.gabrielmarcos.coroutines_sunflower.weather.SuggestionAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_suggestion.view.*

class SuggestionAdapter(
    private val onSuggestionListener: OnSuggestionListener
) : RecyclerView.Adapter<ViewHolder>() {

    private val data = ArrayList<SearchSuggestion>()

    interface OnSuggestionListener {
        fun onSelectedItem(key: String)
    }

    fun setData(banksList: List<SearchSuggestion>) {
        data.clear()
        data.addAll(banksList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_suggestion, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position].localizedName ?: "")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.suggestionTitle

        fun bind(suggestion: String) {
            title.text = suggestion
            itemView.setOnClickListener { chooseItem() }
        }

        private fun chooseItem() {
            onSuggestionListener.onSelectedItem(data[adapterPosition].key ?: "")
        }
    }
}
