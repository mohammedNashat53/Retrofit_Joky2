package com.example.retrofitjoky2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitjoky2.databinding.ActivityMainBinding
import com.example.retrofitjoky2.databinding.ItemTodoBinding

class UlbomesAdapter :RecyclerView.Adapter<UlbomesAdapter.UlbomesViewHolder>() {

    inner class UlbomesViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)

    val differUtil = object: DiffUtil.ItemCallback<Ulbomes>(){
        //
        override fun areItemsTheSame(oldItem: Ulbomes, newItem: Ulbomes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Ulbomes, newItem: Ulbomes): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differUtil)
    var ulbomes: List<Ulbomes>
        get() =differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UlbomesViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UlbomesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UlbomesViewHolder, position: Int) {
        val currentUlbomes = ulbomes[position]
            holder.binding.apply {
            tvId.text = currentUlbomes.id.toString()
            tvIdUsers.text = currentUlbomes.userId.toString()
            tvUserName.text = currentUlbomes.title
            }
    }

    override fun getItemCount() = ulbomes.size

}