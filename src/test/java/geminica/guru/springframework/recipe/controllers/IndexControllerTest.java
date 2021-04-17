package geminica.guru.springframework.recipe.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.services.RecipeService;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    // given
    Recipe r1 = new Recipe();
    r1.setId(1l);
    Recipe r2 = new Recipe();
    r2.setId(2l);
    when(recipeService.findAll()).thenReturn(Set.of(r1, r2));
    ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);

    // when
    String result = indexController.getIndexPage(model);

    // then
    assertEquals("index", result);
    verify(recipeService).findAll();
    verify(model).addAttribute(eq("recipes"), captor.capture());
    Set<Recipe> setInController = captor.getValue();
    assertEquals(2, setInController.size());
  }
}
