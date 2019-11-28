package com.example.soundboard.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(
    @ColumnInfo(name = "categoryName")
    var name: String = "",
    @PrimaryKey(autoGenerate = true)
    var categoryId: Int
)