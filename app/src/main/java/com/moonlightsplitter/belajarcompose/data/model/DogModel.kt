package com.moonlightsplitter.belajarcompose.data.model

import androidx.annotation.DrawableRes
import com.moonlightsplitter.belajarcompose.R

data class DogModel(
    @DrawableRes val image: Int,
    val name: String,
    val age: Int,
    val hobbies: String
)

val dogs = listOf(
    DogModel(R.drawable.lola, "Lola", 16, "Barking at Daddy"),
    DogModel(R.drawable.frankie, "Frankie", 2, "Stealing socks"),
    DogModel(R.drawable.nox, "Nox", 8, "Meeting new animals"),
    DogModel(R.drawable.faye, "Faye", 8, "Digging in the garden"),
    DogModel(R.drawable.bella, "Bella", 14, "Chasing sea foam"),
    DogModel(R.drawable.lola, "Lola", 16, "Barking at Daddy"),
    DogModel(R.drawable.frankie, "Frankie", 2, "Stealing socks"),
    DogModel(R.drawable.nox, "Nox", 8, "Meeting new animals"),
    DogModel(R.drawable.faye, "Faye", 8, "Digging in the garden"),
    DogModel(R.drawable.bella, "Bella", 14, "Chasing sea foam")
)