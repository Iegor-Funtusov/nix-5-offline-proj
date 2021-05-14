package ua.com.nix;

import libs.ReverseString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(ReverseString.reverse("hello"));
        System.out.println(ReverseString.reverse("hello world", "worl"));

    }

}
