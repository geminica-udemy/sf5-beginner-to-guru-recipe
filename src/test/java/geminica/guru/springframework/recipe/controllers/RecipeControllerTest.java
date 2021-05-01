package geminica.guru.springframework.recipe.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {
  private RecipeController recipeController;

  @Mock Model model;
  @Mock RecipeService recipeService;

  @BeforeEach
  void setUp() {
    recipeController = new RecipeController(recipeService);
  }

  @Test
  void testMockMvc() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    mockMvc
        .perform(get("/recipe/show/1"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/show"));
  }

  @Test
  void testRecipeById() {
    // given
    Long id = 1L;
    Recipe expected = new Recipe();
    expected.setId(id);
    when(recipeService.findById(id)).thenReturn(expected);
    ArgumentCaptor<Recipe> captor = ArgumentCaptor.forClass(Recipe.class);

    // when
    String result = recipeController.getRecipe(model, id);

    // then
    assertEquals("recipe/show", result);
    verify(recipeService).findById(id);
    verify(model).addAttribute(eq("recipe"), captor.capture());
    Recipe setInController = captor.getValue();
    assertEquals(expected, setInController);
  }
}
