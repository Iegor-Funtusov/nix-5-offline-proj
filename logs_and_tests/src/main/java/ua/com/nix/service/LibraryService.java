package ua.com.nix.service;

import ua.com.nix.dao.LibraryDao;
import ua.com.nix.model.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final LibraryDao libraryDao = new LibraryDao();

    public void create(Library library) {
        if (library != null) {
            LOGGER_INFO.info("Start create library: ");
            libraryDao.create(library);
            LOGGER_INFO.info("End create library: ");
        }
        else{
            LOGGER_ERROR.error("Library is null!");
        }
    }
    public void update(Library library)
    {
        if (library != null && libraryDao.findById(library.getId())!=null) {
            LOGGER_WARN.warn("Start update library: " + library.getId());
            libraryDao.update(library);
            LOGGER_WARN.warn("End create library: " + library.getId());
        }
        else {
            LOGGER_ERROR.error("Library doesn't exists");
        }
    }
    public void delete(String id)
    {
        if (libraryDao.findById(id)!=null) {
            LOGGER_WARN.warn("Start delete library: " + id);
            libraryDao.delete(id);
            LOGGER_WARN.warn("End delete library: " + id);
        }
        else {
            LOGGER_ERROR.error("Library doesn't exists");
        }
    }
    public Library[] findAll() {
        LOGGER_INFO.info("Read all libraries");
        return libraryDao.findAll();
    }
    public Library findById(String id) {
        if (libraryDao.findById(id) != null) {
            return libraryDao.findById(id);
        }
        LOGGER_ERROR.error("Library doesn't exists");
        return null;
    }

}

