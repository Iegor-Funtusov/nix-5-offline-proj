package org.example.app;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("AppMain.main");

        DogService dogService = new DogService();

        dogService.create(new Dog().setName("Vovkan").setBreed("Bulldog"));
        dogService.create(new Dog().setName("Bandit").setBreed("Pudel"));

        dogService.read().forEach(System.out::println);

    }
}
