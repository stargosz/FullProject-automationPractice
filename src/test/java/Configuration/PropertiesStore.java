package Configuration;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum PropertiesStore {
    BROWSER("browser"),
    BROWSER_FLUENT_TIMEOUT("browser.fluent.timeout"),
    BROWSER_IMPLICIT_TIMEOUT("browser.implicit.timeout"),
    BROWSER_HEADLESS("browser.headless"),
    ENVIRONMENT("environment"),
    BROWSER_ATTACH_SCREENSHOT("browser.attachscreenshot");

    private String value;
    private String propertyKey;
    public static final String CONFIG_PROPERTIES = "config.properties";
    private static Properties properties = null;

    private PropertiesStore(String key) {
        this.propertyKey = key;
        this.value = this.retrieveValue(key);
    }

    private String retrieveValue(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : getValueFromConfigFile(key);
    }

    private String getValueFromConfigFile(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }
        Object objFile = properties.get(key);
        return objFile != null ? Objects.toString(objFile) : null;
    }

    private Properties loadConfigFile() {
        Properties copy = null;
        try {
            InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            try {
                Properties properties = new Properties();
                properties.load(confFileStream);
                copy = properties;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (confFileStream != null) {
                    try {
                        confFileStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.value);
    }

    public int getIntValue() {
        return Integer.parseInt(this.retrieveValue(this.propertyKey));
    }

    public boolean getBoolean() {
        return this.isSpecified() && Boolean.parseBoolean(this.value);
    }

    public String getValue() {
        return this.retrieveValue(this.propertyKey);
    }
}
