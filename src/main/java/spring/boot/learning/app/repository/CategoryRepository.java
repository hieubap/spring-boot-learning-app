package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.entity.ChapterEntity;

@Repository
public interface CategoryRepository  extends CoreRepository<CategoryDTO, CategoryEntity> {

  @Override
  @Query("select e from CategoryEntity e" +
      " where (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null) "
  )
  Page<CategoryEntity> search(CategoryDTO dto, Pageable pageable);
}
