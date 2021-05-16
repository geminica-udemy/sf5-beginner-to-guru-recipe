package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.CategoryCommand;
import geminica.guru.springframework.recipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
  @Nullable
  @Override
  public CategoryCommand convert(Category source) {
    if (source == null) {
      return null;
    }

    return new CategoryCommand(source.getId(), source.getName());
  }
}
