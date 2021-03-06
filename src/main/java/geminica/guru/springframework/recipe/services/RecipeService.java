package geminica.guru.springframework.recipe.services;

import geminica.guru.springframework.recipe.commands.RecipeCommand;
import geminica.guru.springframework.recipe.domain.Recipe;

public interface RecipeService extends CrudService<Recipe, RecipeCommand, Long> {}
