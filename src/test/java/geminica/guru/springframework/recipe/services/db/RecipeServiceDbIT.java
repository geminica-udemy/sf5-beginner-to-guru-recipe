package geminica.guru.springframework.recipe.services.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import geminica.guru.springframework.recipe.commands.RecipeCommand;
import geminica.guru.springframework.recipe.converters.RecipeToRecipeCommand;
import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.repositories.RecipeRepository;
import geminica.guru.springframework.recipe.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceDbIT {
  @Autowired RecipeService service;
  @Autowired RecipeRepository repository;
  @Autowired RecipeToRecipeCommand toCommand;

  @Transactional
  @Test
  void testDescriptionSave() {
    // given
    Recipe sourceRecipe = repository.findAll().iterator().next();
    RecipeCommand command = toCommand.convert(sourceRecipe);
    String expectedDescription = "some interesting description";

    // when
    command.setDescription(expectedDescription);
    RecipeCommand savedCommand = service.saveCommand(command);

    // then
    assertEquals(expectedDescription, savedCommand.getDescription());
    assertEquals(sourceRecipe.getId(), savedCommand.getId());
    assertEquals(sourceRecipe.getIngredients().size(), savedCommand.getIngredients().size());
    assertEquals(sourceRecipe.getCategories().size(), savedCommand.getCategories().size());
  }
}
