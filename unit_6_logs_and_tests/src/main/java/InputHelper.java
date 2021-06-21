import entity.Author;
import entity.Book;
import service.AuthorService;
import service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    public void start() throws IOException {

        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Choose dao: \"1\" - entity.Author, \"2\" - entity.Book, \"3\" - end program");
            String currentChoiceDao = null;
            currentChoiceDao = reader.readLine();
            boolean result = currentChoiceDao.matches("[123]");
            if (!result) {
                continue;
            }

            switch (currentChoiceDao) {
                case ("1"): {

                    first:
                    while (true) {
                        System.out.println("Choose action: \"1\" - create, \"2\" - reed,\"3\" - read all,\"4\" - update,\"5\" - delete, \"6\" - Choose dao, \"7\" - end program");
                        String currentCRUD = reader.readLine();
                        result = currentCRUD.matches("[1234567]");
                        if (!result) {
                            continue;
                        }

                        switch (currentCRUD) {
                            case ("1"): {

                                System.out.println("enter name author");
                                String strName = reader.readLine();
                                authorService.create(strName);
                                break;
                            }
                            case ("2"): {

                                System.out.println("enter id author");
                                String strId = reader.readLine();
                                Author author = authorService.read(Integer.getInteger(strId));
                                break;
                            }
                            case ("3"): {

                                authorService.readAll();
                                break;
                            }
                            case ("4"): {

                                System.out.println("enter id author");
                                String strId = reader.readLine();
                                System.out.println("enter name author");
                                String strName = reader.readLine();
                                authorService.update(Integer.getInteger(strId), strName);
                                break;
                            }
                            case ("5"): {

                                System.out.println("enter id");
                                String strId = reader.readLine();

                                Author author = authorService.read(Integer.getInteger(strId));
                                if (author == null){
                                    break;
                                }

                                Book[] books = bookService.readAll(author);
                                String str = "before deleting an author, you must delete his books, id books: ";
                                if (books.length > 0){
                                    for (int i = 0; i < books.length; i++){
                                        str = str + books[i].getId() + "  ";
                                    }
                                    System.out.println(str);
                                    break;
                                }

                                authorService.delete(Integer.getInteger(strId));
                                break;
                            }
                            case ("6"): {

                                break first;
                            }
                            case ("7"): {

                                System.exit(0);
                                break;
                            }
                        }
                    }

                }
                case ("2"): {
                    second:
                    while (true) {
                        System.out.println("Choose action: \"1\" - create, \"2\" - reed,\"3\" - read all,\"4\" - update,\"5\" - delete, \"6\" - Choose dao, \"7\" - end program");
                        String currentCRUD = reader.readLine();
                        result = currentCRUD.matches("[1234567]");
                        if (!result) {
                            continue;
                        }
                        switch (currentCRUD) {
                            case ("1"): {

                                System.out.println("enter name book");
                                String strName = reader.readLine();
                                System.out.println("enter id author");
                                String strId = reader.readLine();

                                Author author = authorService.read(Integer.getInteger(strId));
                                if (author == null) {
                                    break;
                                }
                                bookService.create(strName, author);
                                break;
                            }
                            case ("2"): {

                                System.out.println("enter id book");
                                String strId = reader.readLine();
                                bookService.read(Integer.getInteger(strId));
                                break;
                            }
                            case ("3"): {

                                bookService.readAll();
                                break;
                            }
                            case ("4"): {
                                System.out.println("enter id book");
                                String strId = reader.readLine();
                                System.out.println("enter new name book");
                                String newName = reader.readLine();
                                System.out.println("enter new id author");
                                String strIdAuthor = reader.readLine();
                                Author author = authorService.read(Integer.getInteger(strIdAuthor));
                                if (author == null) {
                                    break;
                                }
                                bookService.update(Integer.getInteger(strId),newName,author);
                                break;
                            }
                            case ("5"): {

                                System.out.println("enter id book");
                                break;
                            }
                            case ("6"): {

                                break second;

                            }
                            case ("7"): {

                                System.exit(0);
                                break;
                            }
                        }
                        break;
                    }
                }
                case ("3"): {

                    System.exit(0);

                }
            }
        }

    }
}
