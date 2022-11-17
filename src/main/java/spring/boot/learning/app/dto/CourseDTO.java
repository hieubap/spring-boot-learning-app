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
public class CourseDTO extends CoreDTO {
  private Long id;

  private String name;

  private String author;

  // minute
  private Integer duration;

  private Double price;

  private String imageUrl;
}
