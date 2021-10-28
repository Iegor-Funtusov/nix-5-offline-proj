package org.example.entity;

import org.example.csv.CsvMapping;

import java.time.LocalDate;


public class Human {

    @CsvMapping("id")
    private int id;
    @CsvMapping("name")
    private String name;
    @CsvMapping("gender")
    private Gender gender;
    @CsvMapping("date_of_birth")
    private LocalDate dateOfBirth;
    @CsvMapping("number_of_heads")
    private byte numberOfHeads;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte getNumberOfHeads() {
        return numberOfHeads;
    }

    public void setNumberOfHeads(byte numberOfHeads) {
        this.numberOfHeads = numberOfHeads;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfHeads=" + numberOfHeads +
                '}';
    }
}
