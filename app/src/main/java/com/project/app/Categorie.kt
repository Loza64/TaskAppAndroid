package com.project.app

sealed class Categorie {
    data object Personal : Categorie()
    data object Business : Categorie()
    data object Others : Categorie()
}