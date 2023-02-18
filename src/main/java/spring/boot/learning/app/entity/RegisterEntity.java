package spring.boot.learning.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.api.CoreEntity;

@Entity
@Table(name = "register")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class RegisterEntity extends CoreEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "student_id")
  private Long studentId;

  @OneToOne
  @JoinColumn(name = "student_id",insertable = false,updatable = false)
  private AccountEntity student;

  private Long courseId;

  private String imgUrl;

  private Boolean approve;

  private Long authorId;
}