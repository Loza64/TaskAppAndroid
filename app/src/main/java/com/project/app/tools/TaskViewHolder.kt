package com.project.app.tools

import android.content.res.ColorStateList
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

        when (task.type){
            "business" -> checkItemTask.buttonTintList = ColorStateList.valueOf(
                ContextCompat.getColor(checkItemTask.context, R.color.todo_business_category)
            )

            "personal" -> checkItemTask.buttonTintList = ColorStateList.valueOf(
                ContextCompat.getColor(checkItemTask.context, R.color.todo_personal_category)
            )

            else -> checkItemTask.buttonTintList = ColorStateList.valueOf(
                ContextCompat.getColor(checkItemTask.context, R.color.todo_other_category)
            )
        }

        tvTask.text = task.name
    }
}