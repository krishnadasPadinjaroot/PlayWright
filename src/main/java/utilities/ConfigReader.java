package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found.");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getPassword() {
        return get("password");
    }

    public static String getFirstName() {
        return get("firstName");
    }

    public static String getLastName() {
        return get("lastName");
    }

    public static String getZipCode() {
        return get("zipCode");
    }

    public static int getTimeout() {
        return Integer.parseInt(get("timeout"));
    }

    public static int getNavigationTimeout() {
        return Integer.parseInt(get("navigationTimeout"));
    }

    public static boolean isVideoEnabled() {
        return Boolean.parseBoolean(get("recordVideo"));
    }

    public static boolean isTracingEnabled() {
        return Boolean.parseBoolean(get("traceOnFailure"));
    }
}