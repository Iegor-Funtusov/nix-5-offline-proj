package com.lapchenko.kirill.project.app;

import com.lapchenko.kirill.project.lib.Date;
import com.lapchenko.kirill.project.lib.DateParser;
import com.lapchenko.kirill.project.lib.DateUtils;

public class Main {
    public static void main(String[] args) {
        UserDateInterface ui = new UserDateInterface();
        while (true) {
            ui.callRightMethod();
        }
    }
}
