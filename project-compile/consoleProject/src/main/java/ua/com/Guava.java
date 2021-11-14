package ua.com;


import com.google.common.collect.Lists;

import java.util.List;

public class Guava{
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");

        List<String> reversed = Lists.reverse(names);

        System.out.println(reversed.contains("John"));
    }
}