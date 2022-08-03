package com.project.workbenchapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.workbenchapp.util.Constants.Database.HERO_TABLE

@Entity(tableName = HERO_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)
