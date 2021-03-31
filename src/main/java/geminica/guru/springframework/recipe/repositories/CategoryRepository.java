package geminica.guru.springframework.recipe.repositories;

import geminica.guru.springframework.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {}
