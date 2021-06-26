package ua.practice.app.converters;

import com.google.gson.Gson;
import ua.practice.app.entity.Book;

public class BookConverter {

    public static String[] convertBookToStringArray(Book book) {
        Gson gson = new Gson();
        String[] fields = new String[4];
        fields[0] = book.getId();
        fields[1] = book.getName();
        fields[2] = gson.toJson(book.getAuthors());
        fields[3] = String.valueOf(book.isVisible());
        return fields;
    }

}
