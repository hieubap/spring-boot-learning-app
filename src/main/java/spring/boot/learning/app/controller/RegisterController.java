package spring.boot.learning.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.api.CoreController;
import spring.boot.core.api.ResponseDTO;
import spring.boot.learning.app.dto.RegisterDTO;
import spring.boot.learning.app.entity.RegisterEntity;
import spring.boot.learning.app.service.RegisterService;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController extends CoreController<RegisterDTO, RegisterEntity, RegisterService> {
  @Autowired
  private RegisterService registerService;

  public RegisterController(RegisterService s) {
    super(s);
  }

  @GetMapping("/check-register/{id}")
  public ResponseDTO getDetail(@PathVariable("id") Long id) {
    return response(registerService.checkRegister(id));
  }
}
