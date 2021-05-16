package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.IngredientCommand;
import geminica.guru.springframework.recipe.domain.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
  private final UnitOfMeasureCommandToUnitOfMeasure toUnitOfMeasure;

  @Override
  public Ingredient convert(IngredientCommand source) {
    if (source == null) {
      return null;
    }

    Ingredient ingredient = new Ingredient();
    ingredient.setId(source.getId());
    ingredient.setDescription(source.getDescription());
    ingredient.setAmount(source.getAmount());
    ingredient.setUom(toUnitOfMeasure.convert(source.getUom()));
    return ingredient;
  }
}
