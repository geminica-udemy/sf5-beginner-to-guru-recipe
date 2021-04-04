package geminica.guru.springframework.recipe.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(Set<Recipe> recipes) {
    this.recipes = recipes;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Category{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", recipes=").append(recipes);
    sb.append('}');
    return sb.toString();
  }
}
