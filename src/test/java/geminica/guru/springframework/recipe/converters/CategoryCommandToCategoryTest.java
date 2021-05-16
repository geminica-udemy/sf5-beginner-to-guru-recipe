package geminica.guru.springframework.recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import geminica.guru.springframework.recipe.commands.CategoryCommand;
import geminica.guru.springframework.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryCommandToCategoryTest {
  private CategoryCommandToCategory objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new CategoryCommandToCategory();
  }

  @Test
  void testNullSource() {
    assertNull(objectUnderTest.convert(null));
  }

  @Test
  void testEmptySource() {
    assertNotNull(objectUnderTest.convert(new CategoryCommand()));
  }

  @Test
  void testConversion() {
    // given
    long expectedId = 1;
    String expectedName = "name";
    CategoryCommand source = new CategoryCommand(expectedId, expectedName);

    // when
    Category result = objectUnderTest.convert(source);

    // then
    assertNotNull(result);
    assertEquals(expectedId, result.getId());
    assertEquals(expectedName, result.getName());
  }
}
