package geminica.guru.springframework.recipe.controllers;

import geminica.guru.springframework.recipe.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RecipeController {
  private final RecipeService recipeService;

  @RequestMapping({"recipe/show/{id}"})
  public String getRecipe(Model model, @PathVariable Long id) {
    log.info("Get recipe page for id {}", id);
    model.addAttribute("recipe", recipeService.findById(id));
    return "recipe/show";
  }
}
