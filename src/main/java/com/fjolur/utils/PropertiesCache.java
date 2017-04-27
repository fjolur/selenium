package com.fjolur.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {
    private final Properties configProp = new Properties();

    private PropertiesCache() {
        //Private constructor to restrict new instances
        System.out.println("Read all properties from file");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println("Cann't read all properties from file. Exception: " + e);
        }
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

    //Bill Pugh Solution for singleton pattern
    //initialization-on-demand holder idiom
    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }
}