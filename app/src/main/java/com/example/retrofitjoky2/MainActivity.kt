package com.example.retrofitjoky2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.retrofitjoky2.databinding.ActivityMainBinding
import com.example.retrofitjoky2.databinding.ItemTodoBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var  adapter: UlbomesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = UlbomesAdapter()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            delay(3000)
            val request = RetrofitInstanse.api.getUlbomes()
            binding.progressBar.isVisible = false
            adapter.ulbomes = request.body()!!
        }

        binding.recyclerView .adapter = adapter



    }
}