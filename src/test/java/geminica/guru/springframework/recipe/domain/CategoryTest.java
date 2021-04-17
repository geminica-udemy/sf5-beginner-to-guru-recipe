package geminica.guru.springframework.recipe.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
  private Category category;

  @BeforeEach
  void setUp() {
    category = new Category();
  }

  @Test
  void getId() {
    long expected = 4l;
    category.setId(expected);
    assertEquals(expected, category.getId());
  }
}
