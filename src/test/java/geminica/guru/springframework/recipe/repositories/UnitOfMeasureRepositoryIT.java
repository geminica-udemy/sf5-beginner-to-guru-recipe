package geminica.guru.springframework.recipe.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {
  @Autowired UnitOfMeasureRepository repository;

  @Test
  // @DirtiesContext to clean up the database
  void findTeaspoonByUom() {
    Optional<UnitOfMeasure> isTeaspoon = repository.findByUom("Teaspoon");
    assertEquals("Teaspoon", isTeaspoon.get().getUom());
  }

  @Test
  void findCupByUom() {
    Optional<UnitOfMeasure> isTeaspoon = repository.findByUom("Cup");
    assertEquals("Cup", isTeaspoon.get().getUom());
  }
}
