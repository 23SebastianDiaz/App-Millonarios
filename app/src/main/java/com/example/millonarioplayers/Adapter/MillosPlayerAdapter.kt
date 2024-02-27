package com.example.millonarioplayers.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.millonarioplayers.model.MillosPlayerModel
import com.example.millonarioplayers.R

class MillosPlayerAdapter(
    private var millosPlayerList: List<MillosPlayerModel>
) :
    RecyclerView.Adapter<MillosPlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MillosPlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MillosPlayerViewHolder(layoutInflater.inflate(R.layout.item_player, parent, false))
    }

    override fun onBindViewHolder(holder: MillosPlayerViewHolder, position: Int) {
        holder.render(millosPlayerList[position])

    }

    override fun getItemCount() = millosPlayerList.size

    fun updatePlayers(millosPlayerList: List<MillosPlayerModel>) {
        this.millosPlayerList = millosPlayerList
        notifyDataSetChanged()
    }

}