package com.example.listadereceitas.data

import androidx.room.Dao

@Dao
interface RecipeDao {
    @Query("Select * FROM recipe")
    fun getAll() : List<RecipeEntity>

    @Insert
    fun insert(recipe : RecipeEntity)
}
