package com.example.listadereceitas.domain.usecase

import com.example.listadereceitas.domain.model.RecipeDomain
import com.example.listadereceitas.domain.repository.RecipeRepository

abstract class InsertRecipeUsecase(
  private val repository: RecipeRepository
) {
  suspend operator fun invoke(recipe: RecipeDomain) = repository.insert(recipe)
}