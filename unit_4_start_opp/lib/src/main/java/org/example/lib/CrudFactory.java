package org.example.lib;

import javassist.tools.reflect.Reflection;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class CrudFactory {

    private static  CrudFactory instance;
    private static final String ROOT_PACKAGE = "org.example.lib";
    private Set<Class<? extends CrudService>> crudServices;

    private CrudFactory() {
        Reflections reflections = new Reflections(ROOT_PACKAGE);
        crudServices = reflections.getSubTypesOf(CrudService.class);
    }

    public static CrudFactory getInstance() {
        if (instance == null) {
            instance = new CrudFactory();
        }
        return instance;
    }

    public CrudService getCurrent() {
        for (Class<? extends CrudService> aClass : crudServices) {
            System.out.println("aClass = " + aClass.getSimpleName());
            if (!aClass.isAnnotationPresent(Deprecated.class)){
                try {
                    return aClass.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("something");

    }
}
