package helpers;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DataProperties {
  private static Properties PROPERTIES;

  private static void loadProperties() {
    PROPERTIES = new Properties();
    URL props = DataProperties.class.getResource("/data.properties");
    try {
      PROPERTIES.load(props.openStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    if (PROPERTIES == null) loadProperties();
    return PROPERTIES.getProperty(key);
  }

  public static String get(String key) {
    return getProperty(key);
  }

}
