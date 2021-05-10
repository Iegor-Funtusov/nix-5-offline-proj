package com.Lapchenko_Kirill.lib;


import java.beans.JavaBean;

public class CrudFactory {

    private static CrudService crudService;

    private CrudFactory() {

    }

    public CrudService getInstance(String condition) throws CloneNotSupportedException {
        if(condition.equalsIgnoreCase("Array")){
            crudService = new ArrayCrudService();
            return crudService;
        }if(condition.equalsIgnoreCase("Collection")){
            crudService = new ListCrudService();
            return crudService;
        }
        throw new CloneNotSupportedException("This type of crudService currently not supported");
    }
}
