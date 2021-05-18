import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knight {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    Board board = new Board();
    String[][] cells = board.create();

    String knight = "\u265E";
    String position = null;
    String goal = null;
    int x = 0;
    int y = 0;

    public void show() {
        board.show(cells);
    }

    public void location() throws IOException {
        board.show(cells);
        System.out.print("Enter starting coordinates: ");

        LocatingLabel:while (true) {
            position = bufferedReader.readLine();
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    if (cells[x][y].equals(position + " ")) {
                        cells[x][y] = knight + " ";
                        this.x = x;
                        this.y = y;
                        break LocatingLabel;
                    }
                }
            }
            System.out.print("Incorrect location! Try again: ");
        }
        board.show(cells);
    }

    public void finalLocation() throws IOException {
        System.out.print("Enter the coordinates of the finish: ");
        goal = bufferedReader.readLine();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].equals(goal + " ")) {
                    if (cells[this.x][this.y].equals("\u265E ")) {
                        if ((Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1) ||
                                (Math.abs(this.x - x) == 1 && Math.abs(this.y - y) == 2)) {
                            cells[x][y] = cells[this.x][this.y];
                            cells[this.x][this.y] = position + " ";
                        } else {
                            System.out.print("The knight cannot move like this! Try again: ");
                            return;
                        }
                    }
                }
            }
        }
        board.show(cells);
    }

    public static class Board {
        String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String [][] array = new String[8][8];
        public String[][] create(){
            for (int i = letter.length - 1; i >= 0; i--) {
                for (int j = 0; j < letter.length; j++) {
                    array[i][j] = (letter[j] + (i + 1) + " ");
                }
            }
            return array;
        }

        public void show(String[][] array)
        {
            for (int i = array.length-1; i>=0; i--) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
        }
    }
}
