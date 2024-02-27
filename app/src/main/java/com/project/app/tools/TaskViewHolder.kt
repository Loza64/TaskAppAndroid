package com.project.app.tools

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.app.R
import com.project.app.Task

class TaskViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val colorTask = view.findViewById<View>(R.id.colorTask)
    val tvTask = view.findViewById<TextView>(R.id.tvTask)

    fun render(task:Task){

        when (task.type){
            "business" -> {
                colorTask.setBackgroundColor(ContextCompat.getColor(colorTask.context, R.color.todo_business_category))
            }
            "personal" -> {
                colorTask.setBackgroundColor(ContextCompat.getColor(colorTask.context, R.color.todo_personal_category))
            }
            else -> {
                colorTask.setBackgroundColor(ContextCompat.getColor(colorTask.context, R.color.todo_other_category))
            }
        }

        tvTask.text = task.name
    }
}