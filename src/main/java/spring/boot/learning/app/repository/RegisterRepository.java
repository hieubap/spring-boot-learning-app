package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.dto.RegisterDTO;
import spring.boot.learning.app.entity.ChapterEntity;
import spring.boot.learning.app.entity.RegisterEntity;

@Repository
public interface RegisterRepository extends CoreRepository<RegisterDTO, RegisterEntity> {

  @Override
  @Query("select e from RegisterEntity e"
      + " join e.student s" +
      " where (e.courseId = :#{#dto.courseId} or :#{#dto.courseId} is null) " +
      " and (e.authorId = :#{#dto.authorId} or :#{#dto.authorId} is null) " +
      " and (lower(s.fullName) like %:#{#dto.studentName}% or :#{#dto.studentName} is null) " +
      " and (e.studentId = :#{#dto.studentId} or :#{#dto.studentId} is null) "
  )
  Page<RegisterEntity> search(RegisterDTO dto, Pageable pageable);

  boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);

  RegisterEntity findByCourseIdAndStudentId(Long courseId, Long studentId);

  Long countByCourseId(Long courseId);
}
