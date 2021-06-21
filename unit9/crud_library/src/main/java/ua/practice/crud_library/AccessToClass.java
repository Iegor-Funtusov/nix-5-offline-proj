package ua.practice.crud_library;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class AccessToClass {

    public static void addFieldsNamesToHeader(Class<?> clazz, List<String[]> csvData){
        Field[] fields = clazz.getDeclaredFields();
        String[] header = new String[fields.length + 1];
        header[0] = "id";
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            header[i+1] = fields[i].getName();
        }
        csvData.add(header);
    }

    public static String[] addFieldsValuesToCsv(Object o){
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
        return data;
    }

    public static List<BaseEntity> convertStringsToClass(Class<? extends BaseEntity> clazz, List<String[]> csvData){
        List<BaseEntity> objects = new LinkedList<>();
        BaseEntity o = null;
        try {
            if(!csvData.isEmpty()) {
                for (String[] row : csvData) {
                    o = clazz.getDeclaredConstructor().newInstance();
                    Field idField = clazz.getSuperclass().getDeclaredField("id");
                    idField.setAccessible(true);
                    idField.set(o, row[0]);
                    Field[] fields = clazz.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        fields[i].setAccessible(true);
                        Class<?> fieldClazz = fields[i].getType();
                        fields[i].set(o, ConvertUtils.convert(row[i+1], fieldClazz));
                    }
                    objects.add(o);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
