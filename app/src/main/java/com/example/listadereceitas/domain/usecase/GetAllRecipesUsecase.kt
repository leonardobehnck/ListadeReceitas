package com.example.listadereceitas.domain.usecase

import com.example.listadereceitas.domain.repository.RecipeRepository

class GetAllRecipesUsecase(
  private val repository: RecipeRepository
) {
  suspend operator fun invoke() = repository.getAll()
}