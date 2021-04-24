package com.example;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Class2 {

    public static void main(String[] args) {
        System.out.println("Hello from ant build! Class2");
        System.out.println(StringUtils.capitalize("apache commons lang3 library"));
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(CollectionUtils.isEmpty(list));
    }
}
