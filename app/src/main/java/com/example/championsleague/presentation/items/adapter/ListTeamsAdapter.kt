package com.example.championsleague.presentation.items.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleague.R
import com.example.championsleague.model.Team
import com.example.championsleague.presentation.items.holder.ListTeamsHolder
import com.example.championsleague.tools.containsDeAccentLowCase
import java.util.*
import kotlin.collections.ArrayList

class ListTeamsAdapter(
    private var listTeams: ArrayList<Team>,
    private val mListener: (Team) -> Unit
) : RecyclerView.Adapter<ListTeamsHolder>(), Filterable {

    var filteredList: ArrayList<Team> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTeamsHolder {
        val inflatedView = parent.inflate(R.layout.holder_adapter, false)
        return ListTeamsHolder(inflatedView)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onBindViewHolder(holder: ListTeamsHolder, position: Int) {
        val item = filteredList[position]
        holder.binItem(item, mListener)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun addItems(newItems: List<Team>) {
        filteredList.clear()
        filteredList.addAll(newItems)
        this.listTeams.clear()
        this.listTeams.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return itemsFilter
    }

    private val itemsFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults? {
            val results = FilterResults()
            val list = if (constraint.isEmpty()) {
                listTeams
            } else {
                val filterPattern = constraint.toString().toLowerCase(Locale.getDefault()).trim()
                listTeams.filter { it.teamName.containsDeAccentLowCase(filterPattern) }
                listTeams.filter { it.bornYear.containsDeAccentLowCase(filterPattern) }
            }
            results.values = list
            results.count = list.size
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            if (results.values is List<*>) {
                val list = results.values as List<Team>
                filteredList.clear()
                filteredList.addAll(list)
                notifyDataSetChanged()
            }
        }
    }
}