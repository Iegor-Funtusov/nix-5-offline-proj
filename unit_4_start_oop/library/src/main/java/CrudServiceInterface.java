import java.util.Collection;

public interface CrudServiceInterface<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(String id);
    E get(String id);
    Collection<E> getAll();
}
