package geminica.guru.springframework.recipe.services;

import java.util.Set;

public interface CrudService<T, ID> {
  Set<T> findAll();
}
