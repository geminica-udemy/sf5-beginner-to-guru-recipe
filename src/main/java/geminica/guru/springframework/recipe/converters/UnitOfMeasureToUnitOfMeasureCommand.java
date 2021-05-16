package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.UnitOfMeasureCommand;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand
    implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
  @Nullable
  @Override
  public UnitOfMeasureCommand convert(UnitOfMeasure source) {
    if (source == null) {
      return null;
    }

    return new UnitOfMeasureCommand(source.getId(), source.getUom());
  }
}
