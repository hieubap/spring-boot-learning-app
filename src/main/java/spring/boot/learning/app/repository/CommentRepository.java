package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CommentDTO;
import spring.boot.learning.app.entity.CommentEntity;

@Repository
public interface CommentRepository extends CoreRepository<CommentDTO, CommentEntity> {

  @Override
  @Query("select e from CommentEntity e" +
      " where (lower(e.content) like %:#{#dto.content}% or :#{#dto.content} is null) " +
      " and (e.courseId = :#{#dto.courseId} or :#{#dto.courseId} is null) "
  )
  Page<CommentEntity> search(CommentDTO dto, Pageable pageable);

}
