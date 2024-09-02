package com.example.listadereceitas.data.repository

import com.example.listadereceitas.data.dao.RecipeDao
import com.example.listadereceitas.data.mapper.toDomain
import com.example.listadereceitas.data.mapper.toEntity
import com.example.listadereceitas.domain.model.RecipeDomain
import com.example.listadereceitas.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {
  override suspend fun getAll(): List<RecipeDomain> = withContext(Dispatchers.IO) {
    dao.getAll().map { it.toDomain() }
  }

  override suspend fun insert(recipe: RecipeDomain) = withContext(Dispatchers.IO) {
    dao.insert(recipe.toEntity())
  }
}