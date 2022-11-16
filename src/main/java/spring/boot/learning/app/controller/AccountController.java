package spring.boot.learning.app.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.api.CoreController;
import spring.boot.core.api.ResponseDTO;
import spring.boot.learning.app.dto.AccountDTO;
import spring.boot.learning.app.dto.LoginDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController extends CoreController<AccountDTO, AccountEntity, AccountService> {
    public AccountController(AccountService s) {
        super(s);
    }

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody AccountDTO accountDTO) {
        return response(service.register(accountDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginDTO loginDTO, HttpServletRequest httpServletRequest) {
        return response(service.login(loginDTO));
    }

    @PutMapping("/avatar")
    public ResponseDTO avatar(@RequestParam("file") MultipartFile file) {
        return response(service.changeAvatar(file));
    }
}
