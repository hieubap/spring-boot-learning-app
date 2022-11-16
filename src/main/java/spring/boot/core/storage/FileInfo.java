package spring.boot.core.storage;

import java.nio.file.Path;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileInfo {

  private Path absolutePath;

  private Path relativePath;

  private Path fileName;

  private String filePath;
}