package com.example.finalprojectbasketball

import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FinalProjectAdapter (var dataSet : List<Player>):
    RecyclerView.Adapter<FinalProjectAdapter.ViewHolder>() {


        class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = dataSet.size
}