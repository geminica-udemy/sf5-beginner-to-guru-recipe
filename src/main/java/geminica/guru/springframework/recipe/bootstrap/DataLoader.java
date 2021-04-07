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
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    guacamoleNotes.setRecipe(perfectGuacamole);
    perfectGuacamole.setNotes(guacamoleNotes);

    Set<Ingredient> guacamoleIngredients =
        Set.of(
            ingredient(BigDecimal.valueOf(2), piece, "ripe avocados", perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(0.25), teaspoon, "of salt, more to taste", perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(1),
                tablespoon,
                "fresh lime juice or lemon juice",
                perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(2),
                tablespoon,
                "of minced red onion or thinly sliced green onion",
                perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(2),
                tablespoon,
                "cilantro (leaves and tender stems), finely chopped",
                perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(1), dash, "of freshly grated black pepper", perfectGuacamole),
            ingredient(
                BigDecimal.valueOf(0.5),
                piece,
                "ripe tomato, seeds and pulp removed, chopped",
                perfectGuacamole),
            ingredient(null, piece, "Red radishes or jicama, to garnish", perfectGuacamole),
            ingredient(null, piece, "Tortilla chips, to serve", perfectGuacamole));
    perfectGuacamole.setIngredients(guacamoleIngredients);
    recipeRepository.save(perfectGuacamole);
    System.out.println("Perfect Guacamole recipe loaded");

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
    chickenNotes.setRecipe(spicyChicken);
    spicyChicken.setNotes(chickenNotes);

    Set<Ingredient> chickenIngredients =
        Set.of(
            ingredient(BigDecimal.valueOf(2), tablespoon, "ancho chili powder", spicyChicken),
            ingredient(BigDecimal.valueOf(1), teaspoon, "dried oregano", spicyChicken),
            ingredient(BigDecimal.valueOf(1), teaspoon, "dried cumin", spicyChicken),
            ingredient(BigDecimal.valueOf(1), teaspoon, "sugar", spicyChicken),
            ingredient(BigDecimal.valueOf(0.5), teaspoon, "salt", spicyChicken),
            ingredient(BigDecimal.valueOf(1), piece, "clove garlic, finely chopped", spicyChicken),
            ingredient(
                BigDecimal.valueOf(1), tablespoon, "finely grated orange zest", spicyChicken),
            ingredient(
                BigDecimal.valueOf(3), tablespoon, "fresh-squeezed orange juice", spicyChicken),
            ingredient(BigDecimal.valueOf(2), tablespoon, "olive oil", spicyChicken),
            ingredient(
                BigDecimal.valueOf(4),
                piece,
                "skinless, boneless chicken thighs (1 1/4 pounds)",
                spicyChicken),
            ingredient(BigDecimal.valueOf(8), piece, "small corn tortillas", spicyChicken),
            ingredient(BigDecimal.valueOf(3), cup, "packed baby arugula (3 ounces)", spicyChicken),
            ingredient(BigDecimal.valueOf(2), piece, "medium ripe avocados, sliced", spicyChicken),
            ingredient(BigDecimal.valueOf(4), piece, "radishes, thinly sliced", spicyChicken),
            ingredient(BigDecimal.valueOf(0.5), pint, "cherry tomatoes, halved", spicyChicken),
            ingredient(BigDecimal.valueOf(0.25), piece, "red onion, thinly sliced", spicyChicken),
            ingredient(BigDecimal.valueOf(1), piece, "Roughly chopped cilantro", spicyChicken),
            ingredient(
                BigDecimal.valueOf(0.25),
                cup,
                "sour cream thinned with 1/4 cup milk",
                spicyChicken),
            ingredient(BigDecimal.valueOf(1), piece, "lime, cut into wedges", spicyChicken));
    spicyChicken.setIngredients(chickenIngredients);
    recipeRepository.save(spicyChicken);
    System.out.println("Spicy Chicken recipe loaded");
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

  private Ingredient ingredient(
      BigDecimal amount, UnitOfMeasure uom, String description, Recipe recipe) {
    Ingredient i = new Ingredient();
    i.setAmount(amount);
    i.setUom(uom);
    i.setDescription(description);
    i.setRecipe(recipe);
    return i;
  }
}
