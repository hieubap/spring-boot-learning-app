package spring.boot.learning.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.api.CoreDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO extends CoreDTO {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String avatar;

    private String phone;

    private Short role;

    private String description;

    private String aboutMe;

    private String twitter;

    private String linkedIn;

    private String facebook;

    private String github;
}
