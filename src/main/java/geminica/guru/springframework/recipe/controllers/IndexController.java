package geminica.guru.springframework.recipe.controllers;

import geminica.guru.springframework.recipe.domain.Category;
import geminica.guru.springframework.recipe.domain.UnitOfMeasure;
import geminica.guru.springframework.recipe.repositories.CategoryRepository;
import geminica.guru.springframework.recipe.repositories.UnitOfMeasureRepository;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(
      CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage() {
    Optional<Category> american = categoryRepository.findByName("American");
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByUom("Teaspoon");
    System.out.println(american);
    System.out.println(teaspoon);
    return "index";
  }
}
