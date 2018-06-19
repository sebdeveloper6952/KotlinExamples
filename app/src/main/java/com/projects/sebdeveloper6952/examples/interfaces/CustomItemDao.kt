package com.projects.sebdeveloper6952.examples.interfaces

import android.arch.persistence.room.*
import com.projects.sebdeveloper6952.examples.CustomItem

@Dao
interface CustomItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): List<CustomItem>

    @Query("SELECT * FROM items WHERE id like :id")
    fun getById(id: Int): List<CustomItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: CustomItem)

    @Query("DELETE FROM items")
    fun deleteAll()
}