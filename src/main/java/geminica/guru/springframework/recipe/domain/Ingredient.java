package geminica.guru.springframework.recipe.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private BigDecimal amount;
  @EqualsAndHashCode.Exclude @ManyToOne private Recipe recipe;

  @EqualsAndHashCode.Exclude
  @OneToOne(fetch = FetchType.EAGER)
  private UnitOfMeasure uom;
}
