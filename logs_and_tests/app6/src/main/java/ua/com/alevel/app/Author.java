package ua.com.alevel.app;

import ua.com.alevel.lib.CrudFactory;
import ua.com.alevel.lib.BaseEntity;

public class Author extends BaseEntity {
    private String name;
    private String lastname;
    private final CrudFactory crudFactoryBook = new CrudFactory();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }


    public void addBook(Book book) {
        if (!isBook(book)) {
            crudFactoryBook.add(book);
        } else {
            System.out.println("Book already exist");
        }
    }

    public void deleteBook(Book book) {
        if (isBook(book)) {
            crudFactoryBook.remove(crudFactoryBook.indexOf(book));
        } else {
            System.out.println("Book doesn't exist");
        }
    }

    private boolean isBook(Book book) {
        return crudFactoryBook.indexOf(book) != -1;
    }

    private String readAuthorBook() {
        StringBuilder sb = new StringBuilder();
        Book book = null;
        for (int i = 0; i < crudFactoryBook.size(); i++) {
            book = (Book) crudFactoryBook.get(i);
            sb.append(book.getTitle()).append(", ");
        }
        if (book != null) {
            return sb.substring(0, sb.length() - 2);
        } else {
            return "-";
        }
    }

    @Override
    public String toString() {
        return "Author{ID='" + super.getId() + "', Name='" + name + "', Lastname='" + lastname + "' Book{Title='" + readAuthorBook() + "'}";
    }
}
