import org.apache.commons.beanutils.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SetCrudService<E extends BaseEntity> implements CrudServiceInterface<E> {
    Set<E> set = new HashSet<>();

    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        set.add(e);
    }

    public void update(E e) {
        E current = findById(e.getId());
        try {
            BeanUtils.copyProperties(current, e);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        set.removeIf(e -> e.getId().equals(id));

    }

    public E get(String id) {
        return findById(id);
    }

    public Set<E> getAll() {
        return set;
    }

    private String generateId(String id) {
        if (set.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findById(String id) {
        E entity = set
                .stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (entity == null) {
            throw new RuntimeException("entity not exist");
        }
        return entity;
    }
}
