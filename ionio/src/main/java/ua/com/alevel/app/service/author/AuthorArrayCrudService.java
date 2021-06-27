package ua.com.alevel.app.service.author;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.app.service.book.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AuthorArrayCrudService implements AuthorCrudService {
    private List<AuthorService> authorServiceList = new ArrayList<>();

    @Override
    public void create(AuthorService authorService) {
        authorService.setId(generateId(UUID.randomUUID().toString()));
        authorServiceList.add(authorService);
    }

    private String generateId(String id) {
        if (authorServiceList.stream().anyMatch(el -> el.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    @Override
    public void update(AuthorService authorService) {
        AuthorService current = findById(authorService.getId());
        try {
            BeanUtils.copyProperties(current, authorService);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<AuthorService> read() {
        return authorServiceList
                .stream()
                .filter(AuthorService::getVisible)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookService> readList(AuthorService authorService) {
        return authorService.getBookList();
    }

    @Override
    public void delete(AuthorService authorService) {
        authorService.setVisible(false);
    }

    public AuthorService findById(String id) {
        AuthorService current = authorServiceList
                .stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }
}
