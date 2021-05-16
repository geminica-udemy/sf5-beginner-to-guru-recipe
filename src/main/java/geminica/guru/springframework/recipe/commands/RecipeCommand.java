package geminica.guru.springframework.recipe.commands;

import geminica.guru.springframework.recipe.domain.Difficulty;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeCommand {
  private Long id;
  private String description;
  private Integer prepTime;
  private Integer cookTime;
  private Integer servings;
  private String source;
  private String url;
  private String directions;
  private Set<IngredientCommand> ingredients = new HashSet<>();
  private Difficulty difficulty;
  private NotesCommand notes;
  private Set<CategoryCommand> categories = new HashSet<>();
}
