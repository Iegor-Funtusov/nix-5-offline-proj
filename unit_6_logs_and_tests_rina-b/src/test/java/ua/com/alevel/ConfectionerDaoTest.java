package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.dao.ConfectionerDao;
import ua.com.alevel.entity.Confectioner;


public class ConfectionerDaoTest {
    final static private String NAME = "conf";
    final static private Integer Age = 0;
    private static final ConfectionerDao confectionerDao = new ConfectionerDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Confectioner confectioner = new Confectioner();
            confectioner.setName(NAME + i);
            confectioner.setAge(Age + i);
            confectionerDao.createConfectioner(confectioner);
        }
        Confectioner[] conf = confectionerDao.readAllConfectioners().toArray(new Confectioner[0]);
        Assertions.assertEquals(10, conf.length);
    }

    @Test
    @Order(2)
    public void delete() {
        Confectioner[] conf = confectionerDao.readAllConfectioners().toArray(Confectioner[]::new);
        String id = conf[0].getId();
        confectionerDao.deleteConfectioner(id);
        Confectioner[] dessert = confectionerDao.readAllConfectioners().toArray(Confectioner[]::new);
        Assertions.assertEquals(9, dessert.length);
    }

    @Test
    @Order(3)
    public void update() {
        Confectioner[] conf = confectionerDao.readAllConfectioners().toArray(Confectioner[]::new);
        Confectioner current = ConfectionerDao.readConfectioner(conf[0].getId());
        if (current != null) {
            current.setName("sdhfg");
            current.setAge(223);
            confectionerDao.updateConfectioner(current);
        }

        Assertions.assertEquals("sdhfg", current.getName());
    }

    @Test
    @Order(4)
    public void read() {
        Confectioner[] conf = confectionerDao.readAllConfectioners().toArray(Confectioner[]::new);
        Confectioner current = ConfectionerDao.readConfectioner(conf[0].getId());
        Assertions.assertNotNull(current);
    }

}