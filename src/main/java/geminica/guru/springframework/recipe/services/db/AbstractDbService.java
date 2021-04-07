package geminica.guru.springframework.recipe.services.db;

import geminica.guru.springframework.recipe.services.CrudService;
import org.springframework.data.repository.CrudRepository;

class AbstractDbService<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
  private final R repository;

  protected AbstractDbService(R repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<T> findAll() {
    return repository.findAll();
  }
}
