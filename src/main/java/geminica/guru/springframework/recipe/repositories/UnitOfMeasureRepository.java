package geminica.guru.springframework.recipe.repositories;

import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
  Optional<UnitOfMeasure> findByUom(String uom);
}
