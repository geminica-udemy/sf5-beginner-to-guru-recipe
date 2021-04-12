package geminica.guru.springframework.recipe.services.db;

import geminica.guru.springframework.recipe.services.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
class AbstractDbService<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
  private final R repository;

  protected AbstractDbService(R repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<T> findAll() {
    log.info("trying to get all :D");
    return repository.findAll();
  }
}
