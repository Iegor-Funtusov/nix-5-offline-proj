package org.example.csv;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvToEntityMapper {
    public <T> List<T> map(CsvParser parser, Class<T> clazz) {
        List<T> list = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        List<Field> annotatedFields = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CsvMapping.class)) {
                field.setAccessible(true);
                annotatedFields.add(field);
            }
        }

        try {
            for (int i = 0; i < parser.size(); i++) {
                T object = clazz.getConstructor().newInstance();
                for (Field field : annotatedFields) {
                    Class<?> type = field.getType();
                    String column = parser.get(i, field.getAnnotation(CsvMapping.class).value());
                    if (type == byte.class || type == Byte.class) {
                        field.setByte(object, Byte.parseByte(column));
                    } else if (type == short.class || type == Short.class) {
                        field.setShort(object, Short.parseShort(column));
                    } else if (type == int.class || type == Integer.class) {
                        field.setInt(object, Integer.parseInt(column));
                    } else if (type == long.class || type == Long.class) {
                        field.setLong(object, Long.parseLong(column));
                    } else if (type == float.class || type == Float.class) {
                        field.setFloat(object, Float.parseFloat(column));
                    } else if (type == double.class || type == Double.class) {
                        field.setDouble(object, Double.parseDouble(column));
                    } else if (type == boolean.class || type == Boolean.class) {
                        field.setBoolean(object, Boolean.parseBoolean(column));
                    } else if (type == char.class || type == Character.class) {
                        field.setChar(object, column.charAt(0));
                    } else if (type == String.class) {
                        field.set(object, column);
                    } else if (type == LocalDate.class) {
                        field.set(object, LocalDate.parse(column));
                    } else if (type.isEnum()) {
                        Object[] enumConstants = type.getEnumConstants();
                        for (Object constant : enumConstants) {
                            if (constant.toString().equalsIgnoreCase(column)) {
                                field.set(object, constant);
                                break;
                            }
                        }
                    }
                }
                list.add(object);
            }

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
