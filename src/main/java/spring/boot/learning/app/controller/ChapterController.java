package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.ChapterDTO;
import spring.boot.learning.app.entity.ChapterEntity;
import spring.boot.learning.app.service.ChapterService;

@RestController
@RequestMapping("/chapter")
@CrossOrigin
public class ChapterController extends CoreController<ChapterDTO, ChapterEntity, ChapterService> {
  public ChapterController(ChapterService s) {
    super(s);
  }
}
