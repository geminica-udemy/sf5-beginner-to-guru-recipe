package geminica.guru.springframework.recipe.services.db;

import geminica.guru.springframework.recipe.services.CrudService;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
class AbstractDbService<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
  private final R repository;

  protected AbstractDbService(R repository) {
    this.repository = repository;
  }

  @Override
  public Set<T> findAll() {
    log.info("trying to get all :D");
    Set<T> result = new HashSet<>();
    repository.findAll().forEach(result::add);
    return result;
  }

  @Override
  public T findById(ID id) {
    log.info("trying to get by id {}", id);
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Recipe Not Found!"));
  }
}
