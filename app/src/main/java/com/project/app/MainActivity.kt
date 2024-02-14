package com.project.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.app.tools.CategorieAdapter

class MainActivity : AppCompatActivity() {

    private val categorieList = listOf(
        Categorie.Business,
        Categorie.Personal,
        Categorie.Others
    )
    private lateinit var rvCategorie : RecyclerView
    private lateinit var categorieAdapter: CategorieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initComponents() {
        rvCategorie = findViewById(R.id.rvCategorie)
    }

    private fun initUI() {
        initComponents()
        categorieAdapter = CategorieAdapter(categorieList)
        rvCategorie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorie.adapter = categorieAdapter
    }

}