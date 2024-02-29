package com.project.app.tools

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.app.R
import com.project.app.Task

class TaskViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val checkItemTask = view.findViewById<CheckBox>(R.id.checkItemTask)
    val tvTask = view.findViewById<TextView>(R.id.tvTask)

    fun render(task:Task){

        val getColor = when (task.type) {
            "business" -> ContextCompat.getColor(checkItemTask.context, R.color.todo_business_category)
            "personal" -> ContextCompat.getColor(checkItemTask.context, R.color.todo_personal_category)
            else -> ContextCompat.getColor(checkItemTask.context, R.color.todo_other_category)
        }
        tvTask.paintFlags = if(task.isSelected){
            tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        checkItemTask.buttonTintList = ColorStateList.valueOf(getColor)
        checkItemTask.isChecked = task.isSelected
        tvTask.text = task.name
    }
}