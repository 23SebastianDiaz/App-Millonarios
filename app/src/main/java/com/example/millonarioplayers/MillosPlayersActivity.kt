package com.example.millonarioplayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.millonarioplayers.Adapter.MillosPlayerAdapter
import com.example.millonarioplayers.databinding.ActivityMillosPlayersBinding
import com.example.millonarioplayers.model.MillosPlayerModel
import com.example.millonarioplayers.model.MillosPlayerProvider

class MillosPlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMillosPlayersBinding
    private lateinit var adapter: MillosPlayerAdapter
    private var millosPlayerProvider: List<MillosPlayerModel> = MillosPlayerProvider.PlayerList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMillosPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycleView()
        initEditText()

    }

    private fun initRecycleView() {
        adapter = MillosPlayerAdapter(millosPlayerProvider)
        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
        binding.rvPlayers.adapter = adapter
    }

    private fun initEditText(){
        binding.teFilter.addTextChangedListener { userFilter ->
            val playerFiltered = millosPlayerProvider.filter { millosPlayer ->
                millosPlayer.name.lowercase().contains(userFilter.toString().lowercase())
            }
            adapter.updatePlayers(playerFiltered)
        }
    }

}
