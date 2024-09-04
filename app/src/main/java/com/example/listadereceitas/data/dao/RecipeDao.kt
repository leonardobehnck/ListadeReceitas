package com.example.listadereceitas.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.listadereceitas.data.entity.FullRecipe
import com.example.listadereceitas.data.entity.FullRecipeEntity
import com.example.listadereceitas.data.entity.Ingredient
import com.example.listadereceitas.data.entity.PrepareMode
import com.example.listadereceitas.data.entity.Recipe
import com.example.listadereceitas.data.entity.RecipeEntity

@Dao
interface RecipeDao {
    @Query("Select * FROM recipe")
    fun getAll() : List<RecipeEntity>

    @Insert
    fun insert(recipe : Recipe)

    @Insert
    fun insert(ingredient: Ingredient)

    @Insert
    fun insert(prepareMode: PrepareMode)

    @Transaction
    @Query("Select * FROM recipe where id = :recipeId")
    fun getRecipeWithIngredientsAndPrepareMode(recipeId : Int) : FullRecipeEntity

}
