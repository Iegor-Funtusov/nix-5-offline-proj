package ua.com.alevel.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.entity.Confectioner;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConfectionerDao {
    private static Confectioner[] confectioners = new Confectioner[5];
    private int l = 0;

    public void createConfectioner (Confectioner confectioner) {
        if (l + 1 > confectioners.length) {
            int nextL = confectioners.length + 1;
            confectioners = Arrays.copyOf(confectioners, nextL);
        }
        confectioner.setId(UUID.randomUUID().toString());
        confectioners[l] = confectioner;
        l++;
    }

    public static Confectioner readConfectioner (String id) {
        return (Confectioner) findById(id);
    }


    public void updateConfectioner(Confectioner confectioner) {
        Object current = findById(confectioner.getId());
        try {
            BeanUtils.copyProperties(current, confectioner);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    public Collection<Confectioner> readAllConfectioners() {
        return Arrays
                .stream(confectioners)
                .limit(l)
                .map(o -> ((Confectioner) o))
                .collect(Collectors.toList());
    }

    public void deleteConfectioner(String id) {
        Confectioner current = findById(id);
        if (current == null) return;
        Confectioner[] newConfectioner = new Confectioner[confectioners.length-1];
        for (int i = 0, j = 0; i < l; i++) {
            if (id.equals(confectioners[i].getId())) {
                continue;
            }
            newConfectioner[j++] = confectioners[i];
        }
        confectioners = Arrays.copyOf(newConfectioner, confectioners.length - 1);
        l--;
    }

    public static Confectioner findById(String id) {
        for (Confectioner confectioner : confectioners) {
            if (confectioner.getId().equals(id)) {
                return confectioner;
            }
            else {
                return null;
            }
        }
        return null;
    }
}
