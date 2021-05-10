package ua.com.alevel.lib;

import org.apache.commons.beanutils.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Deprecated
public class SetCrudService<E extends BaseEntity> implements CrudService<E> {

    Set<E> list = new HashSet<>();

    public SetCrudService() {
        System.out.println("SetCrudService.SetCrudService");
    }

    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        list.add(e);
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
        list.removeIf(e -> e.getId().equals(id));
    }

    public E read(String id) {
        return findById(id);
    }

    public Set<E> read() {
        return list;
    }

    private String generateId(String id) {
        if (list.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    private E findById(String id) {
        E entity = list
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
