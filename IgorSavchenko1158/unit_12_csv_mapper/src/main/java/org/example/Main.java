package org.example;

import org.example.csv.CsvParser;
import org.example.csv.CsvToEntityMapper;
import org.example.entity.Human;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvParser parser = new CsvParser("humans.csv");
        CsvToEntityMapper mapper = new CsvToEntityMapper();
        List<Human> humans = mapper.map(parser, Human.class);

        System.out.println(humans);
    }
}
