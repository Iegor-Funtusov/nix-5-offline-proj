import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void levels() {
        while (true) {
            System.out.print("1 level\n2 level\n3 level\nExit(0)\nSelect a level number or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                    level1();
                        break;
                    case 2:
                    level2();
                        break;
                    case 3:
                    level3();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
            }
        }
    }

    public void level1() {
        while (true) {
            System.out.print("1.Given an array of numbers.Return the number of unique characters.\n" +
                    "2.The move of a knight on an endless chessboard. The current position of the knight is entered and the cell into which they are trying to move\n" +
                    "  it in 1 move. The program should check if it is possible to do this.\n" +
                    "3.Points A, B, C on the plane are given. Calculate the area of triangle ABC.\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Enter the operation number: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        UniqueValues uniqueValues = new UniqueValues();
                        uniqueValues.uniqueValues();
                        break;
                    case 2:
                        Knight knight = new Knight();
                        knight.location();
                        knight.finalLocation();
                        break;
                    case 3:
                        Triangle triangle = new Triangle();
                        triangle.triangle();
                        break;
                    case 9:
                        levels();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
            }
        }
    }

    public void level2() {
        while (true) {
            System.out.print("1.Given a string containing the characters '(', ')', '{', '}', '[' and ']', determine\n" +
                    "  whether the input string is valid.\n" +
                    "  The input string is valid if:\n" +
                    "  Open parentheses must be closed with parentheses of the same type.\n" +
                    "  Open parentheses must be closed in the correct order.\n" +
                    "  Note that an empty string is also considered valid.\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Enter the operation number: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        Brackets brackets = new Brackets();
                        brackets.Main();
                        break;
                    case 9:
                        levels();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
            }
        }
    }

    public void level3() {
        while (true) {
            System.out.print("1.According to the Wikipedia article, \"The Game of Life, also known simply as Life, is a cellular automaton created by British mathematician\n" +
                    "  John Horton Conway in 1970.\" In the presence of a board with, dimension m by n cells, each cell has an initial state of live (1) or dead (0).\n" +
                    "  Each cell interacts with its eight neighbors (horizontally, vertically and diagonally) using the following four rules (taken from the\n" +
                    "  aforementioned Wikipedia article): Any living cell with fewer than two living neighbors dies as if it were caused by an underpopulation. Any\n" +
                    "  living cell with two or three living neighbors survives to the next generation. Any living cell with more than three living neighbors dies as\n" +
                    "  if it were overpopulated. Any a dead cell with exactly three living neighbors becomes a living cell, as if it were reproducing. Write a\n" +
                    "  function to calculate the next state (after one update) of the board based on its current state. The next state is created by applying the\n" +
                    "  above rules to each cell in the current state, where birth and death occurs simultaneously.\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Enter the operation number: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        new GameOfLife().run();
                        break;
                    case 9:
                        levels();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
            }
        }
    }
}
