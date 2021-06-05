package ua.com.alevel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.dao.DessertDao;
import ua.com.alevel.entity.Dessert;
;


public class DessertDaoTest {
    final static private String NAME = "dessert";
    final static private Integer DATE = 0;
    private static final DessertDao dessertDao = new DessertDao();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Dessert dessert = new Dessert();
            dessert.setName(NAME + i);
            dessert.setDateOfCreation(DATE + i);
            dessertDao.createDessert(dessert);
        }
        Dessert[] desserts = dessertDao.readAllDesserts().toArray(new Dessert[0]);
        Assertions.assertEquals(10, desserts.length);
    }

    @Test
    @Order(2)
    public void delete(){
        Dessert[] desserts = dessertDao.readAllDesserts().toArray(Dessert[]::new);
        String id = desserts[0].getId();
        dessertDao.deleteDessert(id);
        Dessert[] dessert = dessertDao.readAllDesserts().toArray(Dessert[]::new);
        Assertions.assertEquals(9, dessert.length);
    }

    @Test
    @Order(3)
    public void update() {
        Dessert[] desserts = dessertDao.readAllDesserts().toArray(Dessert[]::new);
        Dessert current = dessertDao.readDesert(desserts[0].getId());
        if (current != null ){
            current.setName("sdhfg");
            current.setDateOfCreation(223);
            dessertDao.updateDessert(current);
        }

        Assertions.assertEquals("sdhfg", current.getName());
    }

    @Test
    @Order(4)
    public void read() {
        Dessert[] desserts = dessertDao.readAllDesserts().toArray(Dessert[]::new);
        Dessert current = dessertDao.readDesert(desserts[0].getId());
        Assertions.assertNotNull(current);
    }

}