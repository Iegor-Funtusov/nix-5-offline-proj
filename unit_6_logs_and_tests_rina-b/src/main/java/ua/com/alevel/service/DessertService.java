package ua.com.alevel.service;

import ua.com.alevel.dao.DessertDao;
import ua.com.alevel.entity.Dessert;

import java.util.Collection;

public class DessertService {

    private static DessertDao dessertDao = new DessertDao();

    public void create (Dessert dessert){
        dessertDao.createDessert(dessert);
    }

    public void update (Dessert dessert){
        dessertDao.updateDessert(dessert);
    }

    public static Collection<Dessert> readAll(){
        return dessertDao.readAllDesserts();
    }

    public static Object read(String id){
        return dessertDao.readDesert(id);
    }

    public void delete(String id){
        dessertDao.deleteDessert(id);
    }
}