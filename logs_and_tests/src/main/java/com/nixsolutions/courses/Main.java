package com.nixsolutions.courses;

import com.nixsolutions.courses.controllers.CourseController;

public class Main {

    public static void main(String[] args) {
            CourseController courseController = new CourseController();
            courseController.readConsole();
    }

}
