package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.AdapterMovieBinding
import com.example.myapplication.listItem


class MainAdapter(val Listener: MainActivity) : RecyclerView.Adapter<MainViewHolder>() {

    var peoplelist = mutableListOf<listItem>()

    fun setSongList(peopleList: MutableList<listItem>) {
        this.peoplelist=peopleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item:listItem = peoplelist.get(position)
        holder.binding.name.text =item.jobtitle
        Glide.with(holder.itemView.context).load(item.avatar)
            .into(holder.binding.imageview)

        holder.binding.item.setOnClickListener {
            Listener.onItem(item)
        }

    }

    override fun getItemCount(): Int {
        return peoplelist.size
    }

}


class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {


}
