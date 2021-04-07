package geminica.guru.springframework.recipe.services;

public interface CrudService<T, ID> {
  Iterable<T> findAll();
}
