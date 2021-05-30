package ua.davidenko.authors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.UUID;

public class AuthorsArrayCrud {

    private Authors[] authorsArray = new Authors[0];

    public void create(Authors author) {
        author.setAuthorId(generateId(UUID.randomUUID().toString()));
        Authors[] newAuthorsArray = new Authors[authorsArray.length + 1];
        newAuthorsArray[authorsArray.length] = author;
        System.arraycopy(authorsArray,0,newAuthorsArray,0,authorsArray.length);
        authorsArray = newAuthorsArray;
    }

    public void update(Authors author){
        int numId = findByAuthorId(author.getAuthorId());
        Authors current = authorsArray[numId];
        try {
            BeanUtils.copyProperties(current, author);
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong");
        }
    }

    public void delete(String id) {
        int numId = findByAuthorId(id);
        authorsArray = ArrayUtils.remove(authorsArray, numId);
    }

    public Authors read(String id) {
        return authorsArray[findByAuthorId(id)];
    }

    public Authors[] read() {
       return authorsArray;
    }

    private String generateId(String id) {
        if (Arrays.stream(authorsArray).anyMatch(e -> e.getAuthorId().equals(id))) {
            return generateId(generateId(UUID.randomUUID().toString()));
        }
        return id;
    }

    public int findByAuthorId(String id) {
        for (int i = 0; i < authorsArray.length; i++) {
            if (authorsArray[i].getAuthorId().equals(id))
                return i;
        }
        return -1;
    }
}
