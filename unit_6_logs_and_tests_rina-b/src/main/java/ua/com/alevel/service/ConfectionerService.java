package ua.com.alevel.service;

import ua.com.alevel.dao.ConfectionerDao;
import ua.com.alevel.entity.Confectioner;

import java.util.Collection;

public class ConfectionerService {
    private static ConfectionerDao confectionerDao = new ConfectionerDao();

    public void create (Confectioner confectioner){
        confectionerDao.createConfectioner(confectioner);
    }

    public void update (Confectioner confectioner) {
        confectionerDao.updateConfectioner(confectioner);
    }

    public static Collection<Confectioner> readAll(){
        return confectionerDao.readAllConfectioners();
    }

    public static Object read(String id){
        return confectionerDao.readConfectioner(id);
    }

    public void delete(String id){
        confectionerDao.deleteConfectioner(id);
    }

}