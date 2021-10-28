package org.example;

import org.example.config.Configurator;
import org.example.properties.AppProperties;

public class Main {
    public static void main(String[] args) {
        AppProperties appProperties = new Configurator().initialize(AppProperties.class);
        System.out.println("appProperties = " + appProperties);
    }
}
