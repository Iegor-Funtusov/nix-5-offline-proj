package org.example;

import org.example.level1.WrapAroundChessBoard;

public class Application {
    public static void main(String[] args) {
        System.out.println("Application.main");
//        long res = ArrayUtil.getNumberOfUniqueElements(1, 4, 5, 1, 1, 3);
//        System.out.println(res);

        WrapAroundChessBoard cb = new WrapAroundChessBoard();
        cb.placeFigure(3,2);
        System.out.println(cb);

    }
}
