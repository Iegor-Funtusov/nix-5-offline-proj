package ua.com.nix.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;
import ua.com.nix.model.Library;

import java.util.Arrays;
import java.util.UUID;

public class LibraryDao {
    private int capacity = 0;
    private static int size = 10;

    private static Library[] libraries = new Library[size];

    public void create(Library library) {
        if (capacity + 1 > libraries.length) {
            size = (int) (libraries.length + 1);
            libraries = Arrays.copyOf(libraries, size);
        }
        library.setId(UUID.randomUUID().toString());
        libraries[capacity] = library;
        capacity++;
    }

    public Library[] findAll() {
        return Arrays.stream(libraries)
                .filter(library -> library != null)
                .toArray(Library[]::new);
    }

    public void update(Library library) {
        Library updatedLibrary = findById(library.getId());
        try {
            BeanUtils.copyProperties(updatedLibrary, library);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Library findById(String id) {
        for (Library library : libraries) {
            if (library.getId().equals(id)) {
                return library;
            }
        }
        return null;
    }

    public void delete(String id) {
        Library current = findById(id);
        if (current == null) {
            return;
        }
        int countNulls = 0;
        for(int i=0;i<libraries.length;i++)
        {
            if(libraries[i].getId().equals(id))
            {
                libraries[i]=null;
                break;
            }
        }
        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] == null) {
                countNulls++;
            }
        }
        Library[] tempLibraries = new Library[libraries.length - countNulls];
        for (int i = 0, j = 0; i < libraries.length; i++) {
            if (libraries[i] != null) {
                tempLibraries[j] = libraries[i];
                j++;
            }
        }
        libraries=tempLibraries;
    }
}

