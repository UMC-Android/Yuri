package com.example.umc_study09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study09.retrofit.DailyBoxOffice

class MovieAdapter(private val items: List<DailyBoxOffice>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rank: TextView = itemView.findViewById(R.id.rank)
        private val movieNm: TextView = itemView.findViewById(R.id.movieNM)
        private val openDt: TextView = itemView.findViewById(R.id.openDt)

        fun setItem(item: DailyBoxOffice) {
            rank.text = item.rank
            movieNm.text = item.movieNm
            openDt.text = item.openDt
        }
    }
}
