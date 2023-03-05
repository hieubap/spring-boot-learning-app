package spring.boot.learning.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.BannerDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.BannerEntity;
import spring.boot.learning.app.entity.NotificationEntity;

@Repository
public interface BannerRepository extends CoreRepository<BannerDTO, BannerEntity> {

  @Override
  @Query("select e from BannerEntity e" +
      " where (lower(e.title) like %:#{#dto.title}% or :#{#dto.title} is null) "
  )
  Page<BannerEntity> search(BannerDTO dto, Pageable pageable);
}
