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
public class ChapterDTO extends CoreDTO {
  private Long id;

  private Long courseId;

  private Long name;

  // minute
  private Integer duration;

  private String fileUrl;
}
