package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.IngredientCommand;
import geminica.guru.springframework.recipe.commands.UnitOfMeasureCommand;
import geminica.guru.springframework.recipe.domain.Ingredient;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientCommandToIngredientTest {
  private IngredientCommandToIngredient objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new IngredientCommand()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    BigDecimal expectedAmount = BigDecimal.valueOf(1);
    String expectedDescription = "some";
    IngredientCommand source =
        new IngredientCommand(
            expectedId, expectedAmount, expectedDescription, new UnitOfMeasureCommand());

    // when
    Ingredient result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedDescription, result.getDescription());
    assertEquals(result.getAmount(), result.getAmount());
    assertNotNull(result.getUom());
  }

  @Test
  void testConversionWithNullUom() {
    // given
    long expectedId = 1;
    BigDecimal expectedAmount = BigDecimal.valueOf(1);
    String expectedDescription = "some";
    IngredientCommand source =
        new IngredientCommand(expectedId, expectedAmount, expectedDescription, null);

    // when
    Ingredient result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedDescription, result.getDescription());
    assertEquals(expectedAmount, result.getAmount());
    assertNull(result.getUom());
  }
}
