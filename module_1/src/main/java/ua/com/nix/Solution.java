package ua.com.nix;

import ua.com.nix.realization.level1.ChessGame;
import ua.com.nix.realization.level1.Triangle;
import ua.com.nix.realization.level1.UniqSymbols;
import ua.com.nix.realization.level2.ValidString;
import ua.com.nix.realization.level3.Life_Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public void run () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainLabel:
        while (true) {
            System.out.println("""
                                Enter level:
                                1 -> First
                                2 -> Second
                                3 -> Third
                                0 -> Exit""");
            String level = reader.readLine();
            switch (level) {
                case "1": {
                    while (true) {
                        System.out.println("""
                                Enter task:
                                1 -> Count the number of unique characters
                                2 -> Checking the knight's move
                                3 -> Calculating the area of a triangle
                                0 -> Return to level selection""");
                        String task = reader.readLine();
                        if ("1".equals(task)) {
                            UniqSymbols uniqSymbols = new UniqSymbols();
                            uniqSymbols.fillingStrings();
                        }
                        if ("2".equals(task)) {
                            ChessGame chessGame = new ChessGame();
                            chessGame.EnteringLocation();
                            chessGame.EnteringDestination();
                        }
                        if ("3".equals(task)) {
                            Triangle triangle = new Triangle();
                            triangle.initialize();
                            triangle.calculations();
                        }
                        if("0".equals(task)) {
                           break;
                        }
                    }
                    break;
                }
                case "2": {
                    while (true) {
                        System.out.println("""
                                Enter task:
                                1 -> Checking the validity of a string
                                0 -> Return to level selection""");
                        String task = reader.readLine();
                        if ("1".equals(task)) {
                            ValidString validString = new ValidString();
                            validString.showAnswer();
                        }
                        if ("0".equals(task)) {
                            break;
                        }
                    }
                    break;
                }
                case "3": {
                    while (true) {
                        System.out.println("""
                                Enter task:
                                1 -> Game life
                                0 -> Return to level selection""");
                        String task = reader.readLine();
                        if ("1".equals(task)) {
                            Life_Game life_game = new Life_Game();
                            life_game.processing();
                        }
                        if("0".equals(task)){
                            break;
                        }
                    }
                    break;
                }
                case "0":{
                    break MainLabel;
                }
            }
        }
    }
}
