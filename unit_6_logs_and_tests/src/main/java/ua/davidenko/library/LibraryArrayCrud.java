package ua.davidenko.library;

public class LibraryArrayCrud {
    private static Library[] libraryArray = new Library[0];

    public  void create(Library library) {
        Library[] newLibraryArray = new Library[libraryArray.length + 1];
        newLibraryArray[libraryArray.length] = library;
        System.arraycopy(libraryArray,0,newLibraryArray,0,libraryArray.length);
        libraryArray = newLibraryArray;
    }
}

