package common;

import org.apache.commons.io.FileUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

  public static Properties read(String filename) {
    try {
      FileReader reader = new FileReader(FileUtils.getFile("src", "test", "resources", filename));
      Properties properties = new Properties();
      properties.load(reader);
      return properties;
    } catch (IOException e) {
      System.out.println(String.format("Properties file %s not found", filename));
      return new Properties();
    }
  }

  public static Properties readApplicationProperties() {
    return read(String.format("application-%s.properties", System.getProperty("application.profile")));
  }
}
