package org.QaScript.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    // Create a Properties object to hold the configuration properties
    public static Properties properties = new Properties();

    // FileInputStream object for reading the properties files
    static FileInputStream fis;

    /**
     * Loads the application properties from the application.properties file.
     *
     * @return A Properties object containing the application properties
     */
    public static Properties loadApplicationProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config/application.properties")) {
            // Load the properties from the file
            properties.load(fis);
        } catch (IOException e) {
            // If an exception occurs during file reading, throw a runtime exception
            throw new RuntimeException(e);
        }
        return properties;  // Return the loaded properties
    }

    /**
     * Loads the framework properties from the framework.properties file.
     *
     * @return A Properties object containing the framework properties
     */
    public static Properties loadFrameworkProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config/framework.properties")) {
            // Load the properties from the framework properties file
            properties.load(fis);
        } catch (IOException e) {
            // If an exception occurs during file reading, throw a runtime exception
            throw new RuntimeException(e);
        }
        return properties;  // Return the loaded properties
    }

    /**
     * Loads the user properties from the user.properties file.
     *
     * @return A Properties object containing the user properties
     */
    public static Properties loadUserProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config/user.properties")) {
            // Load the properties from the user properties file
            properties.load(fis);
        } catch (IOException e) {
            // If an exception occurs during file reading, throw a runtime exception
            throw new RuntimeException(e);
        }
        return properties;  // Return the loaded properties
    }
}
