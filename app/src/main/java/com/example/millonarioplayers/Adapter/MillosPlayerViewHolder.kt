package com.example.millonarioplayers.Adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.millonarioplayers.DetailPlayerActivity
import com.example.millonarioplayers.model.MillosPlayerModel

import com.example.millonarioplayers.databinding.ItemPlayerBinding

class MillosPlayerViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemPlayerBinding.bind(view)

    fun render(millosPlayerModel: MillosPlayerModel) {

        binding.tvPlayerName.text = millosPlayerModel.name
        binding.tvPlayerPosition.text = millosPlayerModel.position
        binding.tvPlayerNationality.text = millosPlayerModel.nationality
        binding.tvPlayerAge.text = millosPlayerModel.age
        binding.tvPlayerDorsal.text = millosPlayerModel.dorsal
        Glide.with(binding.ivPlayer.context).load(millosPlayerModel.photo).into(binding.ivPlayer)


        itemView.setOnClickListener {
            val intent = Intent(binding.root.context, DetailPlayerActivity::class.java).apply {
                putExtra("key_name", millosPlayerModel.name)
                putExtra("key_photo", millosPlayerModel.photo)
                putExtra("key_dorsal", millosPlayerModel.dorsal)
                putExtra("key_nationality", millosPlayerModel.nationality)
                putExtra("key_position", millosPlayerModel.position)
                putExtra("key_bibiography", millosPlayerModel.bibiography)
                putExtra("key_cupBetplay", millosPlayerModel.cupBetplay)
            }
            binding.root.context.startActivity(intent)
        }

    }


}
