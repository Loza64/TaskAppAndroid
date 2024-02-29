package com.project.app

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.app.tools.CategorieAdapter
import com.project.app.tools.TaskAdapter

class MainActivity : AppCompatActivity() {

    private val categorieList = mutableListOf(
        Categorie.Personal,
        Categorie.Business,
        Categorie.Other
    )

    private val taskList:MutableList<Task> = mutableListOf(Task("Practicar", Categorie.Personal, false))

    private lateinit var rvCategorie : RecyclerView
    private lateinit var categorieAdapter: CategorieAdapter
    private lateinit var rvTask: RecyclerView
    private lateinit var fbtnNewTask: FloatingActionButton
    private lateinit var taskAdapter:TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initComponents() {
        rvCategorie = findViewById(R.id.rvCategorie)
        rvTask = findViewById(R.id.rvTask)
        fbtnNewTask = findViewById(R.id.fbtnNewTask)
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask = dialog.findViewById<Button>(R.id.btnAddTask)
        val txtTask = dialog.findViewById<EditText>(R.id.txtTask)
        val rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            if(txtTask.text.isNotEmpty()){
                val selectId = rgCategories.checkedRadioButtonId
                val getRadioBtnId = rgCategories.findViewById<RadioButton>(selectId)

                val task: Task = when (getRadioBtnId.text){
                    "Negocios" -> Task(txtTask.text.toString(), Categorie.Business, false)
                    "Personal" -> Task(txtTask.text.toString(), Categorie.Personal, false)
                    else -> Task(txtTask.text.toString(), Categorie.Other, false)
                }
                taskList.add(task)
                taskAdapter.list = taskList
                taskAdapter.notifyDataSetChanged()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun initUI() {
        initComponents()
        categorieAdapter = CategorieAdapter(categorieList){
            position -> categorieSelected(position)
        }
        rvCategorie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorie.adapter = categorieAdapter
        fbtnNewTask.setOnClickListener{ showDialog() }

        taskAdapter = TaskAdapter(taskList){
            position -> taskSelected(position)
        }
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun taskSelected(position: Int){
        taskList[position].isSelected = !taskList[position].isSelected
        taskAdapter.notifyDataSetChanged()
    }

    private fun categorieSelected(position: Int){
        categorieList[position].isDisabled = !categorieList[position].isDisabled
        categorieAdapter.notifyItemChanged(position)

        val selectCategories = categorieList.filterNot { it.isDisabled }
        val newTaskList = taskList.filter { selectCategories.contains(it.type) }
        taskAdapter.list = newTaskList.toMutableList()
        taskAdapter.notifyDataSetChanged()
    }

}