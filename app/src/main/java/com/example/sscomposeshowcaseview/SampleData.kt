package com.example.sscomposeshowcaseview

import com.example.sscomposeshowcaseview.R

object Data {
    var userList = listOf(
        Item(id = 1, profilePic = R.drawable.dp1, name = "Thomas")
    )
}

data class Item(val id: Int, val profilePic: Int, val name: String)