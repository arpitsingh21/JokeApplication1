package com.example.jokeapplication.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Joke(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "joke") val joke: String?
) : Parcelable {
    constructor(joke: String?) : this(0, joke)
}
