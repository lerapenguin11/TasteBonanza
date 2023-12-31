package com.example.tastebonanza.presentation.adapter

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastebonanza.R
import com.example.tastebonanza.business.model.EquipmentModel

class EquipmentAdapter() : RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>(){

    private val equipmentList = mutableListOf<EquipmentModel>()

    private val selectedEquipment = mutableListOf<EquipmentModel>()
    private val checkedItemPositions = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_equipment, parent, false)

        return EquipmentViewHolder(view)
    }

    override fun getItemCount(): Int = equipmentList.size

    override fun onBindViewHolder(holder: EquipmentViewHolder, position: Int) {
        val equipment : EquipmentModel = equipmentList[position]

        holder.text.setText(equipment.name)

        val isSelected = checkedItemPositions.get(position)

        holder.itemView.isSelected = isSelected

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedEquipment.add(equipment)
            } else {
                selectedEquipment.remove(equipment)
            }
            checkedItemPositions.put(position, isChecked)
        }
    }

    fun getSelectedEquipment(): List<EquipmentModel> {
        return selectedEquipment
    }

    fun setItem(equipmentNew: List<EquipmentModel>) {
        equipmentList.clear()
        equipmentList.addAll(equipmentNew)
        notifyDataSetChanged()
    }

    class EquipmentViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val text : TextView = view.findViewById(R.id.tv_equipment)
        val checkBox : CheckBox = view.findViewById(R.id.checkBox)

    }
}