package spring.boot.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.FilenameUtils;
import spring.boot.core.exception.BaseException;

public class FileUtil {

  public static String getExtension(String fileName) {
    if (fileName == null) {
      return null;
    }

    return FilenameUtils.getExtension(fileName).toLowerCase();
  }

  public static void createDirectories(Path path) {
    File file = path.toFile();

    if (file.isFile()) {
      path = path.getParent();
      file = path.toFile();
    }

    if (!file.exists() || !file.isDirectory()) {
      try {
        Files.createDirectories(path);
      } catch (IOException e) {
        throw new BaseException("lỗi create directories");
      }
    }
  }

}