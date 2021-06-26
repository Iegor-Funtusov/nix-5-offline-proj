package ua.practice.app.converters;

import com.google.gson.Gson;
import ua.practice.app.entity.Author;


public class AuthorConverter {

    public static String[] convertAuthorToStringArray(Author author) {
        Gson gson = new Gson();
        String[] fields = new String[5];
        fields[0] = author.getId();
        fields[1] = author.getName();
        fields[2] = author.getLastName();
        fields[3] = gson.toJson(author.getBooks());
        fields[4] = String.valueOf(author.isVisible());
        return fields;
    }
}
