package org.example.properties;

import org.example.config.PropertyKey;

import java.time.LocalTime;

public class AppProperties {

    @PropertyKey("application.active")
    public boolean appActive;
    @PropertyKey("connections.limit")
    public short maxConnections;
    @PropertyKey("connections.timeout")
    public int connectionTimeout;
    @PropertyKey("db.url")
    public String dbUrl;
    @PropertyKey("timer.dailyrestart")
    public LocalTime restartTime;
    @PropertyKey("application.environment")
    public Environment environment;

    public enum Environment {
        DEV, PROD
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "appActive=" + appActive +
                ", maxConnections=" + maxConnections +
                ", connectionTimeout=" + connectionTimeout +
                ", dbUrl='" + dbUrl + '\'' +
                ", restartTime=" + restartTime +
                ", environment=" + environment +
                '}';
    }
}
