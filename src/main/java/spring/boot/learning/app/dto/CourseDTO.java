package spring.boot.learning.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.core.api.CoreDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO extends CoreDTO {
  private Long id;

  private String name;

  private String author;

  private String stk;

  private String nganHang;

  private String chuTaiKhoan;

  // minute
  private Integer duration;

  private Double price;

  private String imageUrl;

  private Short type;

  private Short level;

  private Long categoryId;

  @JsonProperty(access = Access.READ_ONLY)
  private String categoryName;

  @JsonProperty(access = Access.READ_ONLY)
  private String levelName;

  @JsonProperty(access = Access.READ_ONLY)
  private Long numberStudent;

  @JsonProperty(access = Access.READ_ONLY)
  private Long numberComment;
}
