import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthorDao {
    EntityWrapper<Author>[] authors = new EntityWrapper[5];

    public void create(EntityWrapper<Author> author) {
        author.getEntity().setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        EntityWrapper<Author>[] newArray = new EntityWrapper[authors.length + 1];
        for (int i = 0; i < authors.length; i++) {
            newArray[i] = authors[i];
        }
        newArray[authors.length] = author;
        authors = newArray;
    }

    public void update(EntityWrapper<Author> author) {
        EntityWrapper<Author> current = findById(author.getEntity().getId());
        try {
            BeanUtils.copyProperties(current, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int index = getIndexById(id);
        authors = ArrayUtils.remove(authors, index);
    }

    public EntityWrapper<Author>[] getAll() {
        return authors;
    }

    private String generateId(String id) {
        for (EntityWrapper<Author> author : authors) {
            if (author.getEntity().getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private EntityWrapper<Author> findById(String id) {
        return authors[getIndexById(id)];
    }

    private int getIndexById(String id) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getEntity().getId().equals(id)) {
                return i;
            }
        }
        System.out.println("Author with this ID does not exist!!!");
        return -1;
    }
}
