package geminica.guru.springframework.recipe.converters;

import geminica.guru.springframework.recipe.commands.CategoryCommand;
import geminica.guru.springframework.recipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
  @Nullable
  @Override
  public Category convert(CategoryCommand source) {
    if (source == null) {
      return null;
    }

    Category category = new Category();
    category.setId(source.getId());
    category.setName(source.getName());
    return category;
  }
}
