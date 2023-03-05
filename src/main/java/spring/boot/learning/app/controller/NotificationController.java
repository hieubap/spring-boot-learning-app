package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.CourseEntity;
import spring.boot.learning.app.entity.NotificationEntity;
import spring.boot.learning.app.service.CourseService;
import spring.boot.learning.app.service.NotificationService;

@RestController
@RequestMapping("/notification")
@CrossOrigin
public class NotificationController extends CoreController<NotificationDTO, NotificationEntity, NotificationService> {
  public NotificationController(NotificationService s) {
    super(s);
  }
}
