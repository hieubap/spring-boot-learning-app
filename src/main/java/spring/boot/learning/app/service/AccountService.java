package spring.boot.learning.app.service;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.api.CoreService;
import spring.boot.learning.app.dto.AccountDTO;
import spring.boot.learning.app.dto.LoginDTO;
import spring.boot.learning.app.dto.UserDTO;
import spring.boot.learning.app.entity.AccountEntity;

public interface AccountService extends CoreService<AccountDTO, AccountEntity> {
    Map<String,Object> login(LoginDTO dto);

    Boolean verifyUser(String username,String password);

    AccountDTO register(AccountDTO account);

    AccountDTO getCurrentUser();

    Long getCurrentUserId();

    AccountDTO changeAvatar(MultipartFile file);

    UserDTO getUserDTO(Long userId);
}
