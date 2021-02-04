package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class xConfigurationReader {

    private static Properties properties = new Properties();

    // always go first!
    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);
    }
}
