package com.projects.sebdeveloper6952.examples

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "items")
data class CustomItem (
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "item_name") var name: String,
        @ColumnInfo(name = "item_details") var details: String,
        @ColumnInfo(name = "img_id") var imgId: Int
): Serializable