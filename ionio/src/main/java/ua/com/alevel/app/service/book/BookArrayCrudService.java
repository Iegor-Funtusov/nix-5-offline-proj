package ua.com.alevel.app.service.book;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.alevel.app.service.author.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookArrayCrudService implements BookCrudService {
    List<BookService> bookServiceList = new ArrayList<>();

    @Override
    public void create(BookService bookService) {
        bookService.setId(generateId(UUID.randomUUID().toString()));
        bookServiceList.add(bookService);
    }

    @Override
    public void update(String id) {
        BookService current = findById(id);
        try {
            BeanUtils.copyProperties(current, findById(id));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<BookService> read() {
        return bookServiceList
                .stream()
                .filter(BookService::getVisible)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorService> readList(BookService bookService) {
        return bookService.getAuthorList();
    }

    @Override
    public void delete(BookService bookService) {
        bookService.setVisible(false);
    }

    private String generateId(String id) {
        if (bookServiceList.stream().anyMatch(el -> el.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }

    public BookService findById(String id) {
        BookService current = bookServiceList.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }
}
