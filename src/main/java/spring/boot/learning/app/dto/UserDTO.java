package spring.boot.learning.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private Long id;

  private String email;

  private String fullName;

  private String avatar;

  private String phone;

  private String description;

  private String aboutMe;

  private String twitter;

  private String linkedIn;

  private String facebook;

  private String github;

  private String stk;

  private String nganHang;

  private String chuTaiKhoan;
}
