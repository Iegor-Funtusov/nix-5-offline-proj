package service;

public enum FileService {
    FILE_BOOKS("books.txt"),
    FILE_AUTHORS("authors.txt");

    private final String path;

    FileService(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
