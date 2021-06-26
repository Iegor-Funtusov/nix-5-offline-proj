package ua.com.nix;

import ua.com.nix.UI.AuthorUI;
import ua.com.nix.UI.BookUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainLabel:
        while (true) {
            System.out.println("""
                    Choose action:
                    1 -> Book
                    2 -> Authors
                    3 -> CommonTest
                    0 -> Exit""");
            String choice = reader.readLine();
            switch (choice) {
                case "1": {
                    BookUI bookUI = new BookUI();
                    bookUI.bookInterface();
                    break;
                }
                case "2": {
                    AuthorUI authorUI = new AuthorUI();
                    authorUI.authorInterface();
                    break;
                }
                case "3": {
                    File authors = new File("authors.csv");
                    File books = new File("books.csv");
                    authors.delete();
                    books.delete();
                    new CommonTest().test();
                    System.exit(0);
                }
                case "0": {
                    break MainLabel;
                }

            }
        }
    }
}
