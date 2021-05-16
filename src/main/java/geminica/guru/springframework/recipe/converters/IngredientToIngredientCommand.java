package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.IngredientCommand;
import geminica.guru.springframework.recipe.domain.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
  private final UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand;

  @Nullable
  @Override
  public IngredientCommand convert(Ingredient source) {
    if (source == null) {
      return null;
    }

    return new IngredientCommand(
        source.getId(),
        source.getAmount(),
        source.getDescription(),
        toUnitOfMeasureCommand.convert(source.getUom()));
  }
}
