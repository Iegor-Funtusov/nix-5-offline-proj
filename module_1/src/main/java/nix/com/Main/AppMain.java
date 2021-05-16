package nix.com.Main;

import nix.com.lvl_1.area.CalcAreaTriangle;
import nix.com.lvl_1.chess.ChessBoard;
import nix.com.lvl_1.chess.Knight;
import nix.com.lvl_1.chess.Piece;
import nix.com.lvl_1.chess.PieceCoordinate;
import nix.com.lvl_1.unique.NumUniqueSym;
import nix.com.lvl_2.binary_tree.TreeNode;
import nix.com.lvl_2.string_bracket.RegExBracket;
import nix.com.lvl_2.string_bracket.RegExBracket2;

import java.awt.*;

public class AppMain {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 4, 5, 1, 1, 3};
//        NumUniqueSym numUniqueSym = new NumUniqueSym();
//
//        System.out.println(numUniqueSym.getUniqueSymbols(nums));
//
//        Point a = new Point(1,2);
//        Point b = new Point(11,3);
//        Point c = new Point(5,10);
//
//        CalcAreaTriangle calcAreaTriangle = new CalcAreaTriangle(a, b, c);
//        System.out.println(calcAreaTriangle.getArea());
//
//        Piece pieceKnight = new Knight();
//        String start = "A5";
//        String move = "B7";
//        try {
//            pieceKnight.pieceCoordinate = new PieceCoordinate(start);
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        System.out.println("we place on " + start);
//        PieceCoordinate pieceCoordinate1 = null;
//        try {
//            pieceCoordinate1 = new PieceCoordinate(move);
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        ChessBoard chessBoard = new ChessBoard();
//        chessBoard.drawBoard();
//        if (pieceKnight.isCanMove(pieceCoordinate1)) {
//            chessBoard.updateBoard(move);
//        }



        RegExBracket2 regExBracket2 = new RegExBracket2();
        System.out.println(regExBracket2.check("{(aa)} aa)"));


        TreeNode treeNode = new TreeNode(10);

    }
}
