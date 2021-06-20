package ua.practice.crud_library;

import java.lang.reflect.Field;
import java.util.List;

class AccessToClass {

    static void addFieldsNamesToHeader(Class<?> clazz, List<String[]> csvData){
        Field[] fields = clazz.getDeclaredFields();
        String[] header = new String[fields.length + 1];
        header[0] = "id";
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            header[i+1] = fields[i].getName();
        }
        csvData.add(header);
    }

    static void addFieldsValuesToCsv(Object o, List<String[]> csvData){
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String idValue = "";
        try {
            Field idField = clazz.getSuperclass().getDeclaredField("id");
            idField.setAccessible(true);
            idValue = String.valueOf(idField.get(o));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] data = new String[fields.length + 1];
        data[0] = idValue;
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                data[i+1] = String.valueOf(fields[i].get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        csvData.add(data);
    }
}
