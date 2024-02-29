package com.project.app

sealed class Categorie (var isDisabled:Boolean = false){
    object Personal : Categorie()
    object Business : Categorie()
    object Other : Categorie()
}