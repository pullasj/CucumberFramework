package org.QaScript.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties properties = new Properties();
    static FileInputStream fis;

    public static Properties loadApplicationProperties() {

        try (FileInputStream fis = new FileInputStream("src/test/resources/config/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static Properties loadFrameworkProperties() {

        try (FileInputStream fis = new FileInputStream("src/test/resources/config/framework.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static Properties loadUserProperties() {

        try (FileInputStream fis = new FileInputStream("src/test/resources/config/user.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
