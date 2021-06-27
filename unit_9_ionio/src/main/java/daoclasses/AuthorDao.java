package daoclasses;

import dataclasses.Author;
import dataclasses.EntityWrapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthorDao {
    EntityWrapper<Author>[] authors = new EntityWrapper[5];

    public void create(Author author) {
        author.setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        if (authors[authors.length - 1] == null) {
            authors[getCount()] = new EntityWrapper<Author>(author, false);
        } else {
            EntityWrapper<Author>[] newArray = new EntityWrapper[authors.length + authors.length / 2];
            for (int i = 0; i < authors.length; i++) {
                newArray[i] = authors[i];
            }
            newArray[authors.length] = new EntityWrapper<Author>(author, false);
            authors = newArray;
        }
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        try {
            BeanUtils.copyProperties(current, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int index = getIndexById(id);
        authors[index].setDeleted(true);
    }

    public Author[] getAllAuthors() {
        Author[] authorEntities = new Author[getCount()];
        for (int i = 0; i < authorEntities.length; i++) {
            if (!authors[i].isDeleted()) {
                authorEntities[i] = authors[i].getEntity();
            }
        }
        for (int i = 0; i < authorEntities.length; i++) {
            if (authorEntities[i] == null) {
                authorEntities = ArrayUtils.remove(authorEntities, i);
            }
        }
        return authorEntities;
    }

    public EntityWrapper<Author>[] getAllEntities() {
        EntityWrapper<Author>[] authorEntities = new EntityWrapper[getCount()];
        for (int i = 0; i < authorEntities.length; i++) {
            authorEntities[i] = authors[i];
        }
        return authorEntities;
    }

    public void addAuthors(EntityWrapper<Author>[] newAuthors) {
        for (EntityWrapper<Author> newAuthor : newAuthors) {
            if (findById(newAuthor.getEntity().getId()) == null) {
                if (authors[authors.length - 1] == null) {
                    authors[getCount()] = newAuthor;
                } else {
                    EntityWrapper<Author>[] newArray = new EntityWrapper[authors.length + authors.length / 2];
                    for (int i = 0; i < authors.length; i++) {
                        newArray[i] = authors[i];
                    }
                    newArray[authors.length] = newAuthor;
                    authors = newArray;
                }
            } else return;
        }
    }

    private String generateId(String id) {
        for (EntityWrapper<Author> author : authors) {
            if (author != null && author.getEntity().getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private Author findById(String id) {
        if (getIndexById(id) == -1) return null;
        return authors[getIndexById(id)].getEntity();
    }

    public Author getById(String id) {
        return findById(id);
    }

    private int getIndexById(String id) {
        for (int i = 0; i < getCount(); i++) {
            if (authors[i].getEntity().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private int getCount() {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                return i;
            }
        }
        return authors.length;
    }
}