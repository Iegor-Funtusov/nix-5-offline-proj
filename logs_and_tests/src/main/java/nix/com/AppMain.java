package nix.com;

public class AppMain {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        Book book1 = new Book();
        book1.setNumPg(10);
        book1.setTitle("Player ready one");
        bookService.create(book1);

        Book book2 = new Book();
        book2.setNumPg(20);
        book2.setTitle("Player ready one2");
        bookService.create(book2);

        Book[] books = (bookService.readAll());
        System.out.println("create " + books[0] + " " + books[1]);

        //bookDao.delete(books[0].getId());

        books = bookService.readAll();
        System.out.println("delete " + books[0] + " " + books[1]);

        System.out.println("find id" + bookService.findById(books[0].getId()).toString());

        Book bookUpdate = bookService.findById(books[0].getId());
        bookUpdate.setTitle("Hello");
        bookUpdate.setNumPg(10000);

        bookService.update(bookUpdate);

        books = bookService.readAll();
        System.out.println("update " + books[0] + " " + books[1]);
    }
}
