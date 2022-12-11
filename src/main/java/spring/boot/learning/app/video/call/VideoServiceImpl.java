package spring.boot.learning.app.video.call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import spring.boot.core.exception.BaseException;

@Service
public class VideoServiceImpl implements VideoService {
  @Autowired
  private VideoRepository repo;

  @Override
  public VideoEntity getVideo(String name) {
    if(!repo.existsByName(name)){
      throw new BaseException("Name of videoCall Exception");
    }
    return repo.findByName(name);
  }

  @Override
  public List<String> getAllVideoNames() {
    return repo.getAllEntryNames();
  }

  @Override
  public void saveVideo(MultipartFile file, String name) throws IOException {
    if(repo.existsByName(name)){
      throw new VideoAlreadyExistsException();
    }
    VideoEntity newVid = new VideoEntity(name, file.getBytes());
    repo.save(newVid);
  }
}