package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.IngredientCommand;
import geminica.guru.springframework.recipe.domain.Ingredient;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientToIngredientCommandTest {
  private IngredientToIngredientCommand objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new Ingredient()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedDescription = "description";
    BigDecimal expectedAmount = BigDecimal.valueOf(20);
    Ingredient source = new Ingredient();
    source.setId(expectedId);
    source.setDescription(expectedDescription);
    source.setAmount(expectedAmount);
    source.setUom(new UnitOfMeasure());

    // when
    IngredientCommand result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedDescription, result.getDescription());
    assertEquals(expectedAmount, result.getAmount());
    assertNotNull(result.getUom());
  }
}
