package com.example.periodictable.model

import android.graphics.Color
import androidx.annotation.ColorRes
import com.example.periodictable.R


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Eray Belli       │
//│ ──────────────────────── │
//│ erybelli@gmail.com                 │            
//│ ──────────────────────── │
//│ 17.09.2021                  │
//└──────────────────────────┘    

data class   ElementsModel(
    val nesne : Int,
    val protonNumber : String,
    val elementName : String,
    val elementSymbol : String,
    @ColorRes val backGroundColor : Int = R.color.black,
    @ColorRes val textColor : Int = R.color.red
){
}