package spring.boot.learning.app.video.call;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface VideoService {
  VideoEntity getVideo(String name);

  void saveVideo(MultipartFile file, String name) throws IOException;

  List<String> getAllVideoNames();
}
