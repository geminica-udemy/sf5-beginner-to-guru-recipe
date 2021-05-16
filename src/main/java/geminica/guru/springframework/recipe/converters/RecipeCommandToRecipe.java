package geminica.guru.springframework.recipe.converters;

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
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
  private final IngredientCommandToIngredient toIngredient;
  private final NotesCommandToNotes toNotes;
  private final CategoryCommandToCategory toCategory;

  @Nullable
  @Override
  public Recipe convert(RecipeCommand source) {
    if (source == null) {
      return null;
    }

    Recipe recipe = new Recipe();
    recipe.setId(source.getId());
    recipe.setDescription(source.getDescription());
    recipe.setPrepTime(source.getPrepTime());
    recipe.setCookTime(source.getCookTime());
    recipe.setServings(source.getServings());
    recipe.setSource(source.getSource());
    recipe.setUrl(source.getUrl());
    recipe.setDirections(source.getDirections());
    convert(source.getIngredients(), toIngredient).ifPresent(recipe::setIngredients);
    recipe.setDifficulty(source.getDifficulty());
    recipe.setNotes(toNotes.convert(source.getNotes()));
    convert(source.getCategories(), toCategory).ifPresent(recipe::setCategories);
    return recipe;
  }

  private static <T, U> Optional<Set<U>> convert(Set<T> maybeSource, Converter<T, U> converter) {
    return Optional.ofNullable(maybeSource)
        .map(source -> source.stream().map(converter::convert).collect(toSet()));
  }
}
