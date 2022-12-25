package spring.boot.learning.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.core.exception.BaseException;
import spring.boot.core.security.filter.JwtProvider;
import spring.boot.core.security.filter.JwtProvider.JwtTokenProperties;
import spring.boot.core.security.userdetail.UserPrincipal;
import spring.boot.core.storage.FileInfo;
import spring.boot.core.utils.DigestUtil;
import spring.boot.file.service.FileService;
import spring.boot.learning.app.dto.AccountDTO;
import spring.boot.learning.app.dto.LoginDTO;
import spring.boot.learning.app.dto.UserDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.repository.AccountRepository;

@Service
public class AccountServiceImpl
        extends CoreServiceImpl<AccountDTO, AccountEntity> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private FileService fileService;

    @Override
    public AccountEntity mapToEntity(AccountDTO dto) {
        AccountEntity entity = super.mapToEntity(dto);
        if (dto.getId() != null) {
            AccountEntity accountEntity = accountRepository.findById(dto.getId()).orElse(null);

            entity.setUsername(accountEntity.getUsername());
            entity.setPassword(accountEntity.getPassword());
            entity.setRole(accountEntity.getRole());
        }
        return entity;
    }

    @Override
    public Map<String, Object> login(LoginDTO dto) {
        if (dto.getPassword() == null || dto.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập tên đăng nhập hoặc mật khẩu");
        }
        AccountEntity userEntity = accountRepository.findByUsername(dto.getUsername());
        if (userEntity == null) {
            throw new BaseException(400, "Tên đăng nhập không tồn tại");
        }

        if (!DigestUtil.sha256Hex(dto.getPassword()).equals(userEntity.getPassword())) {
            throw new BaseException(400, "password không chính xác");
        }

        List<String> roles = new ArrayList<>();

        if (userEntity.getRole() != null) {
            roles.add("ROLE_" + userEntity.getRole());
        }

        Map<String, Object> additionMap = new HashMap<>();

        JwtTokenProperties jwts = JwtTokenProperties.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .fullName(userEntity.getFullName())
                .email(userEntity.getEmail())
                .description(userEntity.getDescription())
                .role(roles.get(0))
                .avatar(userEntity.getAvatar())
                .privileges(roles)
                .jwtAdditionalInformation(additionMap)
                .build();

        return jwtProvider.generateToken(jwts);
    }

    @Override
    public AccountDTO register(AccountDTO accountDTO) {
        if (accountDTO.getPassword() == null || accountDTO.getUsername() == null) {
            throw new BaseException(400, "Chưa nhập username và password");
        }
        if (accountRepository.existsByUsername(accountDTO.getUsername())) {
            throw new BaseException("Tên đăng nhập đã tồn tại");
        }
        AccountEntity accountEntity = mapToEntity(accountDTO);

        accountEntity.setRole((short) 1);
        accountEntity.setPassword(DigestUtil.sha256Hex(accountDTO.getPassword()));
        save(accountEntity, accountDTO);

        return accountDTO;
    }


    @Override
    public AccountDTO getCurrentUser() {
        return getDetail(getCurrentUserId());
    }

    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        UserPrincipal userDetail = (UserPrincipal) authentication.getPrincipal();
        return userDetail.getId();
    }

    @Override
    public AccountDTO changeAvatar(MultipartFile file) {
        FileInfo fileInfo = fileService.upload(file);
        AccountDTO accountDTO = getCurrentUser();

        if (accountDTO != null) {
            accountDTO.setAvatar(fileInfo.getFilePath());
            save(accountDTO);
        }
        return accountDTO;
    }

    @Override
    public Boolean verifyUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        AccountEntity userEntity = accountRepository.findByUsername(username);
        if (userEntity == null) {
            return false;
        }

        return DigestUtil.sha256Hex(password).equals(userEntity.getPassword());
    }

    @Override
    public UserDTO getUserDTO(Long userId) {
        AccountEntity accountEntity = accountRepository
            .findById(userId)
            .orElse(new AccountEntity());
        return new UserDTO(
            accountEntity.getId(),
            accountEntity.getEmail(),
            accountEntity.getFullName(),
            accountEntity.getAvatar(),
            accountEntity.getPhone(),
            accountEntity.getDescription(),
            accountEntity.getAboutMe(),
            accountEntity.getTwitter(),
            accountEntity.getLinkedIn(),
            accountEntity.getFacebook(),
            accountEntity.getGithub(),
            accountEntity.getStk(),
            accountEntity.getNganHang(),
            accountEntity.getChuTaiKhoan()
            );
    }
}
