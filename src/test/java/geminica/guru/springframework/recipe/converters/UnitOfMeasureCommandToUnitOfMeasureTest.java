package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.UnitOfMeasureCommand;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitOfMeasureCommandToUnitOfMeasureTest {
  private UnitOfMeasureCommandToUnitOfMeasure objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new UnitOfMeasureCommandToUnitOfMeasure();
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new UnitOfMeasureCommand()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedUom = "some";
    UnitOfMeasureCommand source = new UnitOfMeasureCommand(expectedId, expectedUom);

    // when
    UnitOfMeasure result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedUom, result.getUom());
  }
}
