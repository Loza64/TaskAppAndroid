package com.project.app.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.app.Categorie
import com.project.app.R

class CategorieAdapter(private val categorie:List<Categorie>) : RecyclerView.Adapter<CategorieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categorie, parent, false)
        return CategorieViewHolder(view)
    }

    override fun getItemCount() = categorie.size //Retornar el tamaño de la lista

    override fun onBindViewHolder(holder: CategorieViewHolder, position: Int) {
        holder.render(categorie[position])
    }

}