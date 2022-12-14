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
public class CommentDTO extends CoreDTO {
  private Long id;

  private Long courseId;

  private Long userId;

  private String content;

  private UserDTO user;
}
