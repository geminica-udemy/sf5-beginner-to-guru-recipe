package geminica.guru.springframework.recipe.commands;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCommand {
  private Long id;
  private BigDecimal amount;
  private String description;
  private UnitOfMeasureCommand uom;
}
