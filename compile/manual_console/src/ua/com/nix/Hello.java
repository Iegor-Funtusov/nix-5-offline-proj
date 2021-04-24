package ua.com.nix;

import ua.com.nix.print.*;

public class Hello {

    public static void main(String[] args) {
        Print print = new Print();
        print.print();
        System.out.println(print);
        OneMorePrint morePrint = new OneMorePrint();
        morePrint.oneMorePrint();
        System.out.println(morePrint);
    }
}