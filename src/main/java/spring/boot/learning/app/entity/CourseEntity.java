package spring.boot.learning.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.api.CoreEntity;

@Entity
@Table(name = "course")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class CourseEntity extends CoreEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String author;

  // minute
  private Integer duration;

  private Double price;

  private String imageUrl;

  private Short type;
}
