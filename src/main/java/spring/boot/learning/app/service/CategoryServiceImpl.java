package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.entity.CategoryEntity;

@Service
public class CategoryServiceImpl
    extends CoreServiceImpl<CategoryDTO, CategoryEntity> implements CategoryService {

}
