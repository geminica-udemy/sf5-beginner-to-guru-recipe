package geminica.guru.springframework.recipe.services.db;

import geminica.guru.springframework.recipe.services.CrudService;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
class AbstractDbService<T, U, ID, R extends CrudRepository<T, ID>>
    implements CrudService<T, U, ID> {
  private final R repository;
  private final Converter<U, T> fromCommand;
  private final Converter<T, U> toCommand;

  protected AbstractDbService(
      R repository, Converter<U, T> fromCommand, Converter<T, U> toCommand) {
    this.repository = repository;
    this.fromCommand = fromCommand;
    this.toCommand = toCommand;
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

  @Transactional
  @Override
  public U saveCommand(U source) {
    T detached = fromCommand.convert(source);
    T saved = repository.save(detached);
    log.debug("Seved entity {}", saved);
    return toCommand.convert(saved);
  }
}
