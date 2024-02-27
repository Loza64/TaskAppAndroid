package com.project.app.tools

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.app.R
import com.project.app.Task

class TaskViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val colorTask:View = view.findViewById(R.id.colorTask)
    val tvTask = view.findViewById<TextView>(R.id.tvTask)

    fun render(task:Task){
        val color = when (task.type){
            "business" -> ContextCompat.getColor(colorTask.context, R.color.todo_business_category)
            "personal" -> ContextCompat.getColor(colorTask.context, R.color.todo_personal_category)
            else -> ContextCompat.getColor(colorTask.context, R.color.todo_other_category)
        }
        tvTask.setBackgroundColor(color)
        tvTask.text = task.name
    }
}