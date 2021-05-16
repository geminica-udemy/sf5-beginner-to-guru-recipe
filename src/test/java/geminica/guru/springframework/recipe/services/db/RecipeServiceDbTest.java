package geminica.guru.springframework.recipe.services.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import geminica.guru.springframework.recipe.converters.RecipeCommandToRecipe;
import geminica.guru.springframework.recipe.converters.RecipeToRecipeCommand;
import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.repositories.RecipeRepository;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RecipeServiceDbTest {
  private RecipeServiceDb recipeService;

  @Mock RecipeRepository recipeRepository;
  @Mock RecipeCommandToRecipe fromCommand;
  @Mock RecipeToRecipeCommand toCommand;

  @BeforeEach
  void setUp() {
    recipeService = new RecipeServiceDb(recipeRepository, fromCommand, toCommand);
  }

  @Test
  void getRecipeByIdTest() {
    // given
    Long id = 1L;
    Recipe expected = new Recipe();
    expected.setId(id);
    when(recipeRepository.findById(id)).thenReturn(Optional.of(expected));

    // when
    Recipe result = recipeService.findById(id);
    assertEquals(expected, result);
    verify(recipeRepository).findById(id);
  }

  @Test
  void getRecipesTest() {
    // given
    Recipe expected = new Recipe();
    when(recipeRepository.findAll()).thenReturn(Set.of(new Recipe()));

    // when
    Set<Recipe> recipes = recipeService.findAll();

    // then
    assertEquals(1, recipes.size());
    verify(recipeRepository).findAll();
  }
}
