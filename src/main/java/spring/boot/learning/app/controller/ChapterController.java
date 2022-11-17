package spring.boot.learning.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.learning.app.dto.AccountDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.service.AccountService;

@RestController
@RequestMapping("/chapter")
@CrossOrigin
public class ChapterController extends CoreController<AccountDTO, AccountEntity, AccountService> {
  public ChapterController(AccountService s) {
    super(s);
  }
}
