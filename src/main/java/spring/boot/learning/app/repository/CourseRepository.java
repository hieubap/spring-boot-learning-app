package spring.boot.learning.app.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.entity.CourseEntity;

@Repository
public interface CourseRepository extends CoreRepository<CourseDTO, CourseEntity> {

}
