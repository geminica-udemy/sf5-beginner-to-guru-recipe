package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.UnitOfMeasureCommand;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitOfMeasureToUnitOfMeasureCommandTest {
  private UnitOfMeasureToUnitOfMeasureCommand objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new UnitOfMeasureToUnitOfMeasureCommand();
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new UnitOfMeasure()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedUom = "name";
    UnitOfMeasure source = new UnitOfMeasure();
    source.setId(expectedId);
    source.setUom(expectedUom);

    // when
    UnitOfMeasureCommand result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedUom, result.getUom());
  }
}
