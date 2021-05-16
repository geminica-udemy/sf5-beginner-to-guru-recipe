package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.RecipeCommand;
import geminica.guru.springframework.recipe.domain.Category;
import geminica.guru.springframework.recipe.domain.Difficulty;
import geminica.guru.springframework.recipe.domain.Ingredient;
import geminica.guru.springframework.recipe.domain.Notes;
import geminica.guru.springframework.recipe.domain.Recipe;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeToRecipeCommandTest {
  private RecipeToRecipeCommand objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest =
        new RecipeToRecipeCommand(
            new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
            new NotesToNotesCommand(),
            new CategoryToCategoryCommand());
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedDescription = "some";
    Integer expectedPrepTime = 10;
    Integer expectedCookTIme = 20;
    Integer expectedServings = 4;
    String expectedSource = "source";
    String expectedUrl = "url";
    String expectedDirections = "directions";
    Difficulty expectedDifficulty = Difficulty.EASY;
    Recipe source = new Recipe();
    source.setId(expectedId);
    source.setDescription(expectedDescription);
    source.setPrepTime(expectedPrepTime);
    source.setCookTime(expectedCookTIme);
    source.setServings(expectedServings);
    source.setSource(expectedSource);
    source.setUrl(expectedUrl);
    source.setDirections(expectedDirections);
    source.setIngredients(Set.of(new Ingredient()));
    source.setDifficulty(expectedDifficulty);
    source.setNotes(new Notes());
    source.setCategories(Set.of(new Category()));

    // when
    RecipeCommand result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedDescription, result.getDescription());
    assertEquals(expectedPrepTime, result.getPrepTime());
    assertEquals(expectedCookTIme, result.getCookTime());
    assertEquals(expectedServings, result.getServings());
    assertEquals(expectedSource, result.getSource());
    assertEquals(expectedUrl, result.getUrl());
    assertEquals(expectedDirections, result.getDirections());
    assertEquals(1, result.getIngredients().size());
    assertEquals(expectedDifficulty, result.getDifficulty());
    assertNotNull(result.getNotes());
    assertEquals(1, result.getCategories().size());
  }
}
