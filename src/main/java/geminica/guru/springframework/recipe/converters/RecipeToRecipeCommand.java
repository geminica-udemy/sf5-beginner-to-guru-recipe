package geminica.guru.springframework.recipe.converters;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

import geminica.guru.springframework.recipe.commands.RecipeCommand;
import geminica.guru.springframework.recipe.domain.Recipe;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
  private final IngredientToIngredientCommand toIngredientCommand;
  private final NotesToNotesCommand toNotesCommand;
  private final CategoryToCategoryCommand toCategoryCommand;

  @Nullable
  @Override
  public RecipeCommand convert(Recipe source) {
    if (source == null) {
      return null;
    }

    return new RecipeCommand(
        source.getId(),
        source.getDescription(),
        source.getPrepTime(),
        source.getCookTime(),
        source.getServings(),
        source.getSource(),
        source.getUrl(),
        source.getDirections(),
        convert(source.getIngredients(), toIngredientCommand),
        source.getDifficulty(),
        toNotesCommand.convert(source.getNotes()),
        convert(source.getCategories(), toCategoryCommand));
  }

  private static <T, U> Set<U> convert(Set<T> maybeSource, Converter<T, U> converter) {
    return Optional.ofNullable(maybeSource)
        .map(source -> source.stream().map(converter::convert).collect(toSet()))
        .orElse(emptySet());
  }
}
