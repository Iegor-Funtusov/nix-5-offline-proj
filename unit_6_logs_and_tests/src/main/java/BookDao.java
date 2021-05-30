import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class BookDao {
    EntityWrapper<Book>[] books = new EntityWrapper[5];

    public void create(EntityWrapper<Book> book) {
        book.getEntity().setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        EntityWrapper<Book>[] newArray = new EntityWrapper[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newArray[i] = books[i];
        }
        newArray[books.length] = book;
        books = newArray;
    }

    public void update(EntityWrapper<Book> book) {
        EntityWrapper<Book> current = findById(book.getEntity().getId());
        try {
            BeanUtils.copyProperties(current, book);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int index = getIndexById(id);
        books = ArrayUtils.remove(books, index);
    }

    public EntityWrapper<Book>[] getAll() {
        return books;
    }

    private String generateId(String id) {
        for (EntityWrapper<Book> book : books) {
            if (book.getEntity().getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private EntityWrapper<Book> findById(String id) {
        return books[getIndexById(id)];
    }

    private int getIndexById(String id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getEntity().getId().equals(id)) {
                return i;
            }
        }
        System.out.println("Book with this ID does not exist!!!");
        return -1;
    }
}
