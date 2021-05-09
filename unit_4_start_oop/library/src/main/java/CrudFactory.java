import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CrudFactory {
    private static CrudFactory instance;
    private Set<Class<? extends CrudServiceInterface>> crudServiceList;

    private CrudFactory() {
        Reflections reflections = new Reflections("");
        crudServiceList = reflections.getSubTypesOf(CrudServiceInterface.class);
    }

    public CrudServiceInterface getCurrent() {
        for (Class<? extends CrudServiceInterface> aClass : crudServiceList) {
            if (!aClass.isAnnotationPresent(Deprecated.class)) {
                try {
                    return aClass.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("impossible to get class");
    }

    public static CrudFactory getInstance() {
        if (instance == null) {
            instance = new CrudFactory();
        }
        return instance;
    }
}
