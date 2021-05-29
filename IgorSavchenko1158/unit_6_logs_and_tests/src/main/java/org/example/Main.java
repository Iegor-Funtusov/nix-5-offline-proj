package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
        private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.fatal("Priehali");

        System.out.println("Main.main");
        logger.error("Uehali");
    }
}
