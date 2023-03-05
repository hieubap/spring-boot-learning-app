package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.BannerDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.BannerEntity;
import spring.boot.learning.app.entity.NotificationEntity;
import spring.boot.learning.app.service.BannerService;
import spring.boot.learning.app.service.NotificationService;

@RestController
@RequestMapping("/banner")
@CrossOrigin
public class BannerController extends CoreController<BannerDTO, BannerEntity, BannerService> {
  public BannerController(BannerService s) {
    super(s);
  }
}
