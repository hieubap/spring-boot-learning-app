package spring.boot.learning.app.video.call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
  VideoEntity findByName(String name);

  boolean existsByName(String name);

  @Query(nativeQuery = true, value="SELECT name FROM video")
  List<String> getAllEntryNames();
}