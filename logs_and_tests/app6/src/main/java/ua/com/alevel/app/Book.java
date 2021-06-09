package ua.com.alevel.app;

import ua.com.alevel.lib.CrudFactory;
import ua.com.alevel.lib.BaseEntity;

public class Book extends BaseEntity {
    private String title;
    private final CrudFactory crudFactoryAuthor = new CrudFactory();

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        if (!isAuthor(author)) {
            crudFactoryAuthor.add(author);
        } else {
            System.out.println("Author already exist");
        }
    }

    public void deleteAuthor(Author author) {
        if (isAuthor(author)) {
            crudFactoryAuthor.remove(crudFactoryAuthor.indexOf(author));
        } else {
            System.out.println("Author doesn't exist");
        }
    }

    private boolean isAuthor(Author author) {
        return crudFactoryAuthor.indexOf(author) != -1;
    }

    private String readBookAuthor() {
        StringBuilder sb = new StringBuilder();
        Author author = null;
        for (int i = 0; i < crudFactoryAuthor.size(); i++) {
            author = (Author) crudFactoryAuthor.get(i);
            sb.append(author.getLastname()).append(", ");
        }
        if (author != null) {
            return sb.substring(0, sb.length() - 2);
        } else {
            return "-";
        }
    }

    @Override
    public String toString() {
        return "Book{ID='" + super.getId() + "', Title='" + title + "' Author{Lastname='" + readBookAuthor() + "'}";
    }
}
