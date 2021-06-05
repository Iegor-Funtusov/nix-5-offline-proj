package ua.com.alevel.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.entity.RecipeBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class RecipeBookDao {

    private static RecipeBook[] recipeBooks = new RecipeBook[5];
    private int l = 0;

    public void createRecipeBook(RecipeBook recipeBook){
        if (l+1 > recipeBooks.length){
            int nextL = recipeBooks.length + 1;
            recipeBooks = Arrays.copyOf(recipeBooks, nextL);
        }
        recipeBook.setId(UUID.randomUUID().toString());
        recipeBooks[l] = recipeBook;
        l++;
    }

    public RecipeBook readRecipeBook(String id){
        return (RecipeBook) findById(id);
    }

    public void updateRecipeBook(RecipeBook recipeBook){
        Object current = findById(recipeBook.getId());
        try {
            BeanUtils.copyProperties(current, recipeBook);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Collection<RecipeBook> readAllRecipeBooks() {
        return Arrays
                .stream(recipeBooks)
                .limit(l)
                .map(o -> ((RecipeBook) o))
                .collect(Collectors.toList());
    }

    public void deleteRecipeBook(String id) {
        RecipeBook current = findById(id);
        if (current == null) return;
        RecipeBook[] newRecipe = new RecipeBook[recipeBooks.length-1];
        for (int i = 0, k = 0; i < l; i++) {
            if (id.equals(recipeBooks[i].getId())) {
                continue;
            }
            newRecipe[k++] = recipeBooks[i];
        }
        recipeBooks = Arrays.copyOf(newRecipe, recipeBooks.length - 1);
        l--;
    }

    public static RecipeBook findById(String id) {
        for (RecipeBook recipeBook : recipeBooks) {
            if (recipeBook.getId().equals(id)) {
                return recipeBook;
            }
            else {
                return null;
            }
        }
        return null;
    }

}