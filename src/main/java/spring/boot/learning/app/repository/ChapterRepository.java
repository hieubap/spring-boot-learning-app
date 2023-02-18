package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.entity.ChapterEntity;

@Repository
public interface ChapterRepository extends CoreRepository<ChapterDTO, ChapterEntity> {

  @Override
  @Query("select e from ChapterEntity e" +
      " where (lower(e.name) like %:#{#dto.name}% or :#{#dto.name} is null) " +
      " and (e.createdBy = :#{#dto.createdBy} or :#{#dto.createdBy} is null) " +
      " and (e.courseId = :#{#dto.courseId} or :#{#dto.courseId} is null) "
  )
  Page<ChapterEntity> search(ChapterDTO dto, Pageable pageable);

}
