package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.UnitOfMeasureCommand;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure
    implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
  @Nullable
  @Override
  public UnitOfMeasure convert(UnitOfMeasureCommand source) {
    if (source == null) {
      return null;
    }

    UnitOfMeasure uom = new UnitOfMeasure();
    uom.setId(source.getId());
    uom.setUom(source.getUom());
    return uom;
  }
}
