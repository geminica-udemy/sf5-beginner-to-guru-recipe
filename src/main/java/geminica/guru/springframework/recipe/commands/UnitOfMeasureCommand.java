package geminica.guru.springframework.recipe.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasureCommand {
  private Long id;
  private String uom;
}
