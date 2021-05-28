package ua.practice.unit6.application.controller;

import ua.practice.unit6.application.entity.Author;
import ua.practice.unit6.application.service.serviceImpl.AuthorServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class AuthorController {
    AuthorServiceImpl authorService = new AuthorServiceImpl();
    BufferedReader bufferedReader;

    public AuthorServiceImpl getAuthorService() {
        return authorService;
    }

    public AuthorController(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void createAuthor() throws IOException {
        Author author = new Author();
        System.out.println("Input author's name: ");
        author.setName(bufferedReader.readLine());
        authorService.create(author);
    }

    public void updateAuthor() throws IOException {
        System.out.println("Input author's id:");
        String authorId = bufferedReader.readLine();
        Author author = new Author();
        author.setId(authorId);
        System.out.println("Input author's name");
        author.setName(bufferedReader.readLine());
        authorService.update(author);
    }

    public void printAllAuthors(){
        authorService.read().forEach(System.out::println);
    }

    public void printAuthorById() throws IOException {
        System.out.println("Input author's id to print");
        System.out.println(authorService.read(bufferedReader.readLine()));
    }

    public void deleteAuthor() throws IOException {
        System.out.println("Input author's id to delete");
        authorService.delete(bufferedReader.readLine());
    }

}
