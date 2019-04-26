package com.github.satoshun.example.material.appbar.chips

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chip_item.view.*

class ChipAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RecyclerView.ViewHolder {
    return object : RecyclerView.ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.chip_item, parent, false)
    ) {}
  }

  override fun getItemCount(): Int = 100

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    holder.itemView.chip.text = "test $position"
  }
}
