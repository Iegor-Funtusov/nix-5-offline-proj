package com.keyplate.project;
import com.keyplate.project.app.UniversityUserInterface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UniversityUserInterface ui = new UniversityUserInterface();
        ui.chooseMethod();
    }
}
