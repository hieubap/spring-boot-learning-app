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
public class RegisterDTO extends CoreDTO {
  private Long id;

  private Long studentId;

  private Long courseId;

  private String imgUrl;

  private Boolean approve;

  private Long authorId;

  @JsonProperty(access = Access.READ_ONLY)
  private String courseName;

  @JsonProperty(access = Access.READ_ONLY)
  private String studentName;

}