package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.entity.ChapterEntity;

@Service
public class ChapterServiceImpl
    extends CoreServiceImpl<ChapterDTO, ChapterEntity> implements ChapterService {

}
