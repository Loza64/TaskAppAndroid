package com.project.app.tools

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.app.Categorie
import com.project.app.R

class CategorieViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCategorie:TextView = view.findViewById(R.id.tvCategorie)
    private val divider:View  = view.findViewById(R.id.divider)
    private val itemCategorie:CardView = view.findViewById(R.id.itemCategorie)

    fun render(categorie: Categorie){
         when (categorie){
             Categorie.Personal ->{
                 tvCategorie.text = "Personal"
                 divider.setBackgroundColor( ContextCompat.getColor(divider.context, R.color.todo_personal_category))
             }
             Categorie.Business ->{
                 tvCategorie.text = "Negocio"
                 divider.setBackgroundColor( ContextCompat.getColor(divider.context, R.color.todo_business_category))
             }
             Categorie.Other -> {
                 tvCategorie.text = "Otros"
                 divider.setBackgroundColor( ContextCompat.getColor(divider.context, R.color.todo_other_category))
             }
         }

        val stateColor = if(!categorie.isDisabled){
            ContextCompat.getColor(itemCategorie.context, R.color.todo_background_card)
        }else{
            ContextCompat.getColor(itemCategorie.context, R.color.todo_background_disabled)
        }
        itemCategorie.setCardBackgroundColor(stateColor)
    }
}