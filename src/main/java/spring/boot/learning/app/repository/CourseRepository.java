package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.entity.CourseEntity;

@Repository
public interface CourseRepository extends CoreRepository<CourseDTO, CourseEntity> {

  @Override
  @Query("select e from CourseEntity e" +
      " where (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null) "
  )
  Page<CourseEntity> search(CourseDTO dto, Pageable pageable);
}
