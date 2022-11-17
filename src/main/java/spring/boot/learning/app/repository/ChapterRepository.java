package spring.boot.learning.app.repository;

import org.springframework.stereotype.Repository;
import spring.boot.core.api.CoreRepository;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.entity.ChapterEntity;

@Repository
public interface ChapterRepository extends CoreRepository<ChapterDTO, ChapterEntity> {

}
