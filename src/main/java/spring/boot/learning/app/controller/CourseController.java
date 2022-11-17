package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.AccountDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.service.AccountService;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController extends CoreController<AccountDTO, AccountEntity, AccountService> {
  public CourseController(AccountService s) {
    super(s);
  }
}
