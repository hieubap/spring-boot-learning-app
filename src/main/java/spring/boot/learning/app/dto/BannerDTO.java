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
public class BannerDTO extends CoreDTO {
  private Long id;

  private String title;

  private String content;

  private String imageUrl;
}
