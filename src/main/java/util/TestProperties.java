package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private final Properties properties = new Properties();
    private static TestProperties INSTANCE;

    private TestProperties() {
        try {
            properties.load(new FileReader(String.format("src/main/resources/%s.properties", "environment")));
//            Раскомментировать для запуска с опцией - Denvironment = environment
//            properties.load(new FileReader(String.format("src/main/resources/%s.properties", System.getProperty("environment"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
