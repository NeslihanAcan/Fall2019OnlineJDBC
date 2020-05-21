package com.jdbc.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties configFile;
    static {
        try {

            FileInputStream input = new FileInputStream("configuration.properties");
            configFile = new Properties();

            configFile.load(input);

            input.close();

        } catch (IOException e) {

        }

    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
