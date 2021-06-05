package ua.com.alevel.service;

import ua.com.alevel.dao.RecipeBookDao;
import ua.com.alevel.entity.RecipeBook;

import java.util.Collection;

public class RecipeBookService {
    private RecipeBookDao recipeBookDao = new RecipeBookDao();

    public void create (RecipeBook recipeBook){
        recipeBookDao.createRecipeBook(recipeBook);
    }

    public void update (RecipeBook recipeBook){
        recipeBookDao.updateRecipeBook(recipeBook);
    }

    public Collection<RecipeBook> readAll(){
        return recipeBookDao.readAllRecipeBooks();
    }

    public Object read(String id){
        return recipeBookDao.readRecipeBook(id);
    }

    public void delete(String id){
        recipeBookDao.deleteRecipeBook(id);
    }
}