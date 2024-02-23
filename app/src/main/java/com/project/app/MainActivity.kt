package com.project.app

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.app.tools.CategorieAdapter

class MainActivity : AppCompatActivity() {

    private val categorieList = listOf(
        Categorie.Business,
        Categorie.Personal,
        Categorie.Others
    )
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
        dialog.show()
    }

    private fun initUI() {
        initComponents()
        categorieAdapter = CategorieAdapter(categorieList)
        rvCategorie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorie.adapter = categorieAdapter
        fbtnNewTask.setOnClickListener{
            showDialog()
        }
    }

}