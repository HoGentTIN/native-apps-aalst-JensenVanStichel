package com.example.soundboard

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "sound_table")
data class Sound(
    @ColumnInfo(name = "soundName")
    var naam: String = "",
    @ColumnInfo(name = "soundCategory")
    var category: Category,
    @ColumnInfo(name = "soundURL")
    var URL: String = "",
    @PrimaryKey(autoGenerate = true)
    var soundId: Int
)