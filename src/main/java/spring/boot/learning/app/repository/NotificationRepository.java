package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.entity.NotificationEntity;

@Repository
public interface NotificationRepository extends CoreRepository<NotificationDTO, NotificationEntity> {

  @Override
  @Query("select e from NotificationEntity e" +
      " where (lower(e.title) like %:#{#dto.title}% or :#{#dto.title} is null) "
  )
  Page<NotificationEntity> search(NotificationDTO dto, Pageable pageable);
}
