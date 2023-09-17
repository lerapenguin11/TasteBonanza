package com.example.tastebonanza.business.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tastebonanza.business.model.Equipment
import com.example.tastebonanza.business.model.Ingredients
import com.example.tastebonanza.business.model.Recipe

@Database(entities = [Equipment::class, Recipe::class, Ingredients::class], version = 6)
@TypeConverters(EquipmentConverter::class, IngredientsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun equipmentDao(): EquipmentDao
    abstract fun recipeDao(): RecipeDao
    abstract fun ingredientsDao(): IngredientsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "recipes_database_6"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}