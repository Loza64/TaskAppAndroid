package com.project.app

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.app.tools.CategorieAdapter
import com.project.app.tools.TaskAdapter

class MainActivity : AppCompatActivity() {

    private val categorieList = listOf(
        Categorie.Business,
        Categorie.Personal,
        Categorie.Others
    )

    private val taskList:List<Task> = listOf<Task>()

    private lateinit var rvCategorie : RecyclerView
    private lateinit var categorieAdapter: CategorieAdapter
    private lateinit var rvTask: RecyclerView
    private lateinit var fbtnNewTask: FloatingActionButton

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
            val selectId = rgCategories.checkedRadioButtonId
            val getRadioBtnId = rgCategories.findViewById<RadioButton>(selectId)
            val task: Task = when (getRadioBtnId.text){
                "rBtnBusiness" -> {
                    Task(
                        txtTask.text.toString(),
                        ContextCompat.getColor(this, R.color.todo_business_category)
                    )
                }

                "rBtnPersonal" -> {
                    Task(
                        txtTask.text.toString(),
                        ContextCompat.getColor(this, R.color.todo_personal_category)
                    )
                }

                else -> Task(txtTask.text.toString(), ContextCompat.getColor(this, R.color.todo_other_category))

            }

            taskList.plus(task)
            rvTask.adapter = TaskAdapter(taskList)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun initUI() {
        initComponents()
        categorieAdapter = CategorieAdapter(categorieList)
        rvCategorie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorie.adapter = categorieAdapter
        fbtnNewTask.setOnClickListener{ showDialog() }

        rvTask.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTask.adapter = TaskAdapter(taskList)
    }

}