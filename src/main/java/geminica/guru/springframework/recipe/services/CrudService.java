package geminica.guru.springframework.recipe.services;

import java.util.Set;

public interface CrudService<T, U, ID> {
  Set<T> findAll();

  T findById(ID id);

  U saveCommand(U source);
}
