package geminica.guru.springframework.recipe.bootstrap;

import geminica.guru.springframework.recipe.domain.Category;
import geminica.guru.springframework.recipe.domain.Difficulty;
import geminica.guru.springframework.recipe.domain.Ingredient;
import geminica.guru.springframework.recipe.domain.Notes;
import geminica.guru.springframework.recipe.domain.Recipe;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import geminica.guru.springframework.recipe.repositories.CategoryRepository;
import geminica.guru.springframework.recipe.repositories.RecipeRepository;
import geminica.guru.springframework.recipe.repositories.UnitOfMeasureRepository;
import java.math.BigDecimal;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;
  private final RecipeRepository recipeRepository;

  public DataLoader(
      CategoryRepository categoryRepository,
      UnitOfMeasureRepository unitOfMeasureRepository,
      RecipeRepository recipeRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.recipeRepository = recipeRepository;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Category mexican = category("Mexican");
    Category american = category("American");

    UnitOfMeasure piece = unitOfMeasure("Piece");
    UnitOfMeasure teaspoon = unitOfMeasure("Teaspoon");
    UnitOfMeasure tablespoon = unitOfMeasure("Tablespoon");
    UnitOfMeasure dash = unitOfMeasure("Dash");
    UnitOfMeasure cup = unitOfMeasure("Cup");
    UnitOfMeasure pint = unitOfMeasure("Pint");

    Recipe perfectGuacamole = new Recipe();
    perfectGuacamole.setDescription("How to Make Perfect Guacamole");
    perfectGuacamole.getCategories().add(mexican);
    perfectGuacamole.setPrepTime(10);
    perfectGuacamole.setCookTime(0);
    perfectGuacamole.setServings(4);
    perfectGuacamole.setDifficulty(Difficulty.EASY);
    perfectGuacamole.setSource("Internet");
    perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

    perfectGuacamole.setDirections(
        "1. Cut the avocado, remove flesh\n"
            + "2. Mash with a fork\n"
            + "3. Add salt, lime juice, and the rest\n"
            + "4. Serve immediately");

    Notes guacamoleNotes = new Notes();
    guacamoleNotes.setNotes(
        "Be careful handling chiles if using. Wash your hands thoroughly after handling and do not"
            + " touch your eyes or the area near your eyes with your hands for several hours.");
    perfectGuacamole.setNotes(guacamoleNotes);

    perfectGuacamole
        .addIngredient(ingredient(BigDecimal.valueOf(2), piece, "ripe avocados"))
        .addIngredient(ingredient(BigDecimal.valueOf(0.25), teaspoon, "of salt, more to taste"))
        .addIngredient(
            ingredient(BigDecimal.valueOf(1), tablespoon, "fresh lime juice or lemon juice"))
        .addIngredient(
            ingredient(
                BigDecimal.valueOf(2),
                tablespoon,
                "of minced red onion or thinly sliced green onion"))
        .addIngredient(
            ingredient(
                BigDecimal.valueOf(2),
                tablespoon,
                "cilantro (leaves and tender stems), finely chopped"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), dash, "of freshly grated black pepper"))
        .addIngredient(
            ingredient(
                BigDecimal.valueOf(0.5), piece, "ripe tomato, seeds and pulp removed, chopped"))
        .addIngredient(ingredient(null, piece, "Red radishes or jicama, to garnish"))
        .addIngredient(ingredient(null, piece, "Tortilla chips, to serve"));
    recipeRepository.save(perfectGuacamole);
    log.info("Perfect Guacamole recipe loaded");

    Recipe spicyChicken = new Recipe();
    spicyChicken.setDescription("Spicy Grilled Chicken Tacos");
    spicyChicken.getCategories().add(american);
    spicyChicken.getCategories().add(mexican);
    spicyChicken.setPrepTime(20);
    spicyChicken.setCookTime(15);
    spicyChicken.setServings(6);
    spicyChicken.setDifficulty(Difficulty.EASY);
    spicyChicken.setSource("Internet");
    spicyChicken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

    spicyChicken.setDirections(
        "1. Prepare a gas or charcoal grill for medium-high, direct heat\n"
            + "2. Make the marinade and coat the chicken\n"
            + "3. Grill the chicken\n"
            + "4. Warm the tortillas\n"
            + "5. Assemble the tacos");

    Notes chickenNotes = new Notes();
    chickenNotes.setNotes(
        "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it"
            + " online. (If you can't find ancho chili powder, you replace the ancho chili, the"
            + " oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the"
            + " flavor won't be quite the same.)");
    spicyChicken.setNotes(chickenNotes);

    spicyChicken
        .addIngredient(ingredient(BigDecimal.valueOf(2), tablespoon, "ancho chili powder"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), teaspoon, "dried oregano"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), teaspoon, "dried cumin"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), teaspoon, "sugar"))
        .addIngredient(ingredient(BigDecimal.valueOf(0.5), teaspoon, "salt"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), piece, "clove garlic, finely chopped"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), tablespoon, "finely grated orange zest"))
        .addIngredient(ingredient(BigDecimal.valueOf(3), tablespoon, "fresh-squeezed orange juice"))
        .addIngredient(ingredient(BigDecimal.valueOf(2), tablespoon, "olive oil"))
        .addIngredient(
            ingredient(
                BigDecimal.valueOf(4), piece, "skinless, boneless chicken thighs (1 1/4 pounds)"))
        .addIngredient(ingredient(BigDecimal.valueOf(8), piece, "small corn tortillas"))
        .addIngredient(ingredient(BigDecimal.valueOf(3), cup, "packed baby arugula (3 ounces)"))
        .addIngredient(ingredient(BigDecimal.valueOf(2), piece, "medium ripe avocados, sliced"))
        .addIngredient(ingredient(BigDecimal.valueOf(4), piece, "radishes, thinly sliced"))
        .addIngredient(ingredient(BigDecimal.valueOf(0.5), pint, "cherry tomatoes, halved"))
        .addIngredient(ingredient(BigDecimal.valueOf(0.25), piece, "red onion, thinly sliced"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), piece, "Roughly chopped cilantro"))
        .addIngredient(
            ingredient(BigDecimal.valueOf(0.25), cup, "sour cream thinned with 1/4 cup milk"))
        .addIngredient(ingredient(BigDecimal.valueOf(1), piece, "lime, cut into wedges"));
    recipeRepository.save(spicyChicken);
    log.info("Spicy Chicken recipe loaded");
  }

  private Category category(String category) {
    return categoryRepository
        .findByName(category)
        .orElseThrow(
            () ->
                new IllegalArgumentException(String.format("%s category was not found", category)));
  }

  private UnitOfMeasure unitOfMeasure(String uom) {
    return unitOfMeasureRepository
        .findByUom(uom)
        .orElseThrow(() -> new IllegalArgumentException(String.format("%s was not found", uom)));
  }

  private Ingredient ingredient(BigDecimal amount, UnitOfMeasure uom, String description) {
    Ingredient i = new Ingredient();
    i.setAmount(amount);
    i.setUom(uom);
    i.setDescription(description);
    return i;
  }
}
