package spring.boot.learning.app.video.call;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "video")
@Data
@NoArgsConstructor
public class VideoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String name;

  @Lob
  private byte[] data;

  public VideoEntity(String name, byte[] data) {
    this.name = name;
    this.data = data;
  }
}