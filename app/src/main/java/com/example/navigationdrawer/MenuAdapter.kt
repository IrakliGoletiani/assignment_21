package com.example.navigationdrawer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.example.navigationdrawer.databinding.MenuItemBinding

typealias ItemMenuOnClick = (position: Int) -> Unit

class MenuAdapter(private val items:MutableList<ItemMenu>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    lateinit var itemMenuOnClick: ItemMenuOnClick

    var selectedPosition= 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = items.size

    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        fun onBind(){
            val model = items[adapterPosition]
            binding.imageView.setImageResource(model.image)
            binding.textView.text = model.title
            binding.root.setOnClickListener(this)

            if (adapterPosition == selectedPosition){
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.teal_200))

                binding.view.visibility = View.VISIBLE
            }else{
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
                binding.view.visibility = View.INVISIBLE

            }
        }

        override fun onClick(v: View?) {
            selectedPosition = adapterPosition
            notifyDataSetChanged()
            itemMenuOnClick.invoke(adapterPosition)
        }

    }

}
