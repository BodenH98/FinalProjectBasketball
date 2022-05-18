package com.example.finalprojectbasketball

import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class FinalProjectAdapter (var dataSet : List<Player>):
    RecyclerView.Adapter<FinalProjectAdapter.ViewHolder>() {



        class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
            val layout:ConstraintLayout
            val textViewPlayerGuessed:TextView
            init {
                layout = view.findViewById(R.id.Layout_playeritem)
                textViewPlayerGuessed = view.findViewById(R.id.item_textview_playerGuessed)
            }

        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.activity_player_item,viewGroup,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val playerInfo = dataSet[position]
        viewHolder.textViewPlayerGuessed.text = "${playerInfo.first_name} ${playerInfo.last_name} ${playerInfo.teamname} ${playerInfo.position}"
        viewHolder.layout.setOnClickListener {
            val context = viewHolder.layout.context
            val playerDetailIntent = Intent(context,PlayerDetailActivity::class.java).apply {
                putExtra(PlayerDetailActivity.EXTRA_PLAYER,playerInfo)
            }
            context.startActivity(playerDetailIntent)
        }
    }

    override fun getItemCount() = dataSet.size
}