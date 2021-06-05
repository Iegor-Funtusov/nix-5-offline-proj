package ua.com.alevel.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.entity.Dessert;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class DessertDao {

    private static Dessert[] desserts = new Dessert[5];
    private int l = 0;

    public void createDessert(Dessert dessert) {
        if (l + 1 > desserts.length) {
            int nextL = desserts.length + 1;
            desserts = Arrays.copyOf(desserts, nextL);
        }
        dessert.setId(UUID.randomUUID().toString());
        desserts[l] = dessert;
        l++;
    }

    public Dessert readDesert(String id) {
        return (Dessert) findById(id);
    }


    public void updateDessert(Dessert dessert) {
        Object current = findById(dessert.getId());
        try {
            BeanUtils.copyProperties(current, dessert);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Collection<Dessert> readAllDesserts() {
        return Arrays
                .stream(desserts)
                .limit(l)
                .map(o -> ((Dessert) o))
                .collect(Collectors.toList());
    }

    public void deleteDessert(String id) {
        Dessert current = findById(id);
        if (current == null) return;
        Dessert[] newDessert = new Dessert[desserts.length-1];
        for (int i = 0, k = 0; i < l; i++) {
            if (id.equals(desserts[i].getId())) {
                continue;
            }
            newDessert[k++] = desserts[i];
        }
        desserts = Arrays.copyOf(newDessert, desserts.length - 1);
        l--;
    }

    public Dessert findById(String id) {
        for (Dessert dessert : desserts) {
            if (dessert.getId().equals(id)) {
                return dessert;
            }
            else {
                return null;
            }
        }
        return null;
    }
}