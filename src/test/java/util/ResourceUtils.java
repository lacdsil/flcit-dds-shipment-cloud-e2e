package util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@UtilityClass
@Slf4j
public class ResourceUtils {

  public static String readFile(String directory, String filename) {
    try {
      File file = FileUtils.getFile("src", "test", "resources", "data", directory, filename);
      return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    } catch (IOException e) {
      log.error(String.format("failed to read from file: %s/%s", directory, filename), e);
      return null;
    }
  }
}
