package spring.boot.learning.app.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.entity.CategoryEntity;

@Repository
public interface CategoryRepository  extends CoreRepository<CategoryDTO, CategoryEntity> {

}
