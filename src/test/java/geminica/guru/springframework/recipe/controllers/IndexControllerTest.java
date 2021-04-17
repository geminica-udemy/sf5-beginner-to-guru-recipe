package geminica.guru.springframework.recipe.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import geminica.guru.springframework.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {
  private IndexController indexController;

  @Mock Model model;
  @Mock RecipeService recipeService;

  @BeforeEach
  void setUp() {
    indexController = new IndexController(recipeService);
  }

  @Test
  void testIndexPage() {
    // when
    String result = indexController.getIndexPage(model);

    // then
    assertEquals("index", result);
    verify(recipeService).findAll();
    verify(model).addAttribute(eq("recipes"), anySet());
  }
}
