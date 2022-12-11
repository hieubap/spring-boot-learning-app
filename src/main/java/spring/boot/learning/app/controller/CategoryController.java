package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController extends CoreController<CategoryDTO, CategoryEntity, CategoryService> {
  public CategoryController(CategoryService s) {
    super(s);
  }
}