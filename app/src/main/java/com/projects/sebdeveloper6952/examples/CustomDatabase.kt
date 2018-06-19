package com.projects.sebdeveloper6952.examples

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.projects.sebdeveloper6952.examples.interfaces.CustomItemDao

@Database(
        entities = arrayOf(CustomItem::class),
        version = 1,
        exportSchema = false)
abstract class CustomDatabase: RoomDatabase() {

    abstract fun customItemDao(): CustomItemDao

    companion object {

        const val ITEMS_DB_NAME = "items"
        private var INSTANCE: CustomDatabase? = null

        fun getInstance(context: Context): CustomDatabase? {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CustomDatabase::class.java,
                        "items.db"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}