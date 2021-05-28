package ua.com.nix;

import ua.com.nix.UI.AuthorUI;
import ua.com.nix.UI.BookUI;
import ua.com.nix.UI.LibraryUI;


import java.io.BufferedReader;
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
                    3 -> Library
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
                    LibraryUI libraryUI = new LibraryUI();
                    libraryUI.libraryInterface();
                    break;
                }
                case "0": {
                    break MainLabel;
                }

            }
        }
     }
}
