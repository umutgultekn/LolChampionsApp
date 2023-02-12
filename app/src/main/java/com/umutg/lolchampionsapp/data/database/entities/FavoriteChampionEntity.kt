package com.umutg.lolchampionsapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "champion")
data class FavoriteChampionEntity(

    @PrimaryKey val id: String,

    @ColumnInfo val name: String,

    @ColumnInfo val title: String,

    @ColumnInfo val image: String

)