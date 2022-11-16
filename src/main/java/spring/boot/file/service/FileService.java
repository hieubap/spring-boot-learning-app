package spring.boot.file.service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.storage.FileInfo;


public interface FileService {

  ResponseEntity<byte[]> getImage(String fileName, HttpServletRequest httpServletRequest)
      throws IOException;


  FileInfo upload(MultipartFile file);

}
