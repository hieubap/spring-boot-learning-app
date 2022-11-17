package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.entity.CourseEntity;
import spring.boot.learning.app.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController extends CoreController<CourseDTO, CourseEntity, CourseService> {
  public CourseController(CourseService s) {
    super(s);
  }
}
