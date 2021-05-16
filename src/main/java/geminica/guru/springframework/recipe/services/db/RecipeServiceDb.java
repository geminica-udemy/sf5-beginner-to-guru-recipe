package geminica.guru.springframework.recipe.services.db;

import geminica.guru.springframework.recipe.commands.RecipeCommand;
import geminica.guru.springframework.recipe.converters.RecipeCommandToRecipe;
import geminica.guru.springframework.recipe.converters.RecipeToRecipeCommand;
import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.repositories.RecipeRepository;
import geminica.guru.springframework.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceDb
    extends AbstractDbService<Recipe, RecipeCommand, Long, RecipeRepository>
    implements RecipeService {
  public RecipeServiceDb(
      RecipeRepository repository,
      RecipeCommandToRecipe fromCommand,
      RecipeToRecipeCommand toCommand) {
    super(repository, fromCommand, toCommand);
  }
}
