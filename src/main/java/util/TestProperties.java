package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private Properties properties = null;
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties = new Properties();
//            properties.load(new FileInputStream("src/main/resources/application.properties"));
            properties.load(new FileInputStream("src/main/resources/" + System.getProperty("env") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
}
