package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.Properties;

public class Configurator {
    private static final String PROPS = "/app.properties";

    public <T> T initialize(Class<T> clazz) {
        Properties properties = readProperties();
        T instance;
        try {
            instance = clazz.getConstructor().newInstance();
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(PropertyKey.class)) {
                    String key = field.getAnnotation(PropertyKey.class).value();
                    String value = properties.getProperty(key);
                    Class<?> type = field.getType();
                    if (type == byte.class || type == Byte.class) {
                        field.set(instance, Byte.parseByte(value));
                    } else if (type == short.class || type == Short.class) {
                        field.set(instance, Short.parseShort(value));
                    } else if (type == int.class || type == Integer.class) {
                        field.set(instance, Integer.parseInt(value));
                    } else if (type == long.class || type == Long.class) {
                        field.set(instance, Long.parseLong(value));
                    } else if (type == float.class || type == Float.class) {
                        field.set(instance, Float.parseFloat(value));
                    } else if (type == double.class || type == Double.class) {
                        field.set(instance, Double.parseDouble(value));
                    } else if (type == boolean.class || type == Boolean.class) {
                        field.set(instance, Boolean.parseBoolean(value));
                    } else if (type == char.class || type == Character.class) {
                        field.set(instance, value.charAt(0));
                    } else if (type == String.class) {
                        field.set(instance, value);
                    } else if (type == LocalTime.class) {
                        field.set(instance, LocalTime.parse(value));
                    } else if (type.isEnum()) {
                        Object[] constants = type.getEnumConstants();
                        for (Object constant : constants) {
                            if (constant.toString().equalsIgnoreCase(value)) {
                                field.set(instance, constant);
                            }
                        }
                    }
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        return instance;
    }

    private Properties readProperties() {
        Properties properties = new Properties();

        try (InputStream stream = getClass().getResourceAsStream(PROPS)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }
}
