package com.example.recyclerviewclicklistener

import java.io.Serializable

data class ClothingItem(
    val image: Int,
    var title: String,
    var description: String
) : Serializable