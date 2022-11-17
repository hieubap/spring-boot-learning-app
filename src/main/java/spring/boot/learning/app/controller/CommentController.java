package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.CommentDTO;
import spring.boot.learning.app.entity.CommentEntity;
import spring.boot.learning.app.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController extends CoreController<CommentDTO, CommentEntity, CommentService> {
  public CommentController(CommentService s) {
    super(s);
  }
}
