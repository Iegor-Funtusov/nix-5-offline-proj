import javax.xml.stream.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ChessBoard chessBoard = new ChessBoard();
        String[][] cells = chessBoard.create();
        String figure = null;
        String location = null;
        String destination = null;
        String color = null;
        String vibor = null;
        int x_from = 0;
        int y_from = 0;

        MainLabel: while (true) {
            boolean isDestination = true;
            boolean isLocation = true;
            System.out.println("Choose figure with one letter: 1(Pawn),2(Queen),3(King),4(Bishop),5(Hourse),6(Rook)");
            figure = reader.readLine();
            switch(figure) {
                case "1":
                    System.out.println("You have chosen a pawn" + "\n");
                    figure = "P";
                    break;
                case "2":
                    System.out.println("You have chosen a queen"+ "\n");
                    figure = "Q";
                    break;
                case "3":
                    System.out.println("You have chosen a king"+ "\n");
                    figure = "K";
                    break;
                case "4":
                    System.out.println("You have chosen a bishop"+ "\n");
                    figure = "B";
                    break;
                case "5":
                    System.out.println("You have chosen a hourse"+ "\n");
                    figure = "H";
                    break;
                case "6":
                    System.out.println("You have chosen a rook"+ "\n");
                    figure = "R";
                    break;
                default:
                    System.out.println("This figure does not exist, please try again.");
                    figure = reader.readLine();
                    break;
            }
            System.out.println("Choose color: 1(White) or 2(Black)");
            color = reader.readLine();
            switch (color) {
                case "1":
                    System.out.println("You have chosen a black color" + "\n");
                    color = "B";
                    break;
                case "2":
                    System.out.println("You have chosen a white color" + "\n");
                    color = "W";
                    break;
                default:
                    System.out.println("This color does not exist, please try again.");
                    color = reader.readLine();
                    break;
            }

            chessBoard.show(cells);
            System.out.println("Enter location's coordinates: ");

            while (isLocation){
            location = reader.readLine();
            System.out.println("Incorrect location,try again: ");

            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    if (cells[x][y].equals(location + " ")) {
                        cells[x][y] = figure + color + " ";
                        x_from = x;
                        y_from = y;
                        isLocation = false;
                    }}}
            }

            chessBoard.show(cells);

            while (isDestination) {
                System.out.println("Enter destination's coordinates");
                destination = reader.readLine();
                someLabel:
                for (int x = 0; x < cells.length; x++) {
                    for (int y = 0; y < cells[x].length; y++) {
                        if (cells[x][y].equals(destination + " ")) {
                            if (cells[x_from][y_from].equals("BW ") || cells[x_from][y_from].equals("BB ")) {
                                if ((x_from - y_from) == (x - y) || (x_from + y_from) == (x + y)) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination=false;
                                } else {
                                    System.out.println("Bishop can't move like that,try again: ");
                                    break someLabel;
                                }
                            }
                            if (cells[x_from][y_from].equals("QW ") || cells[x_from][y_from].equals("QB ")) {
                                if (y_from == y && x_from != x || y_from != y && x_from == x || (x_from - y_from) == (x - y) || (x_from + y_from) == (x + y)) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination = false;
                                } else {
                                    System.out.println("Queen can't move like that,try again: ");
                                    break someLabel;
                                }
                            }
                            if (cells[x_from][y_from].equals("RW ") || cells[x_from][y_from].equals("RB ")) {
                                if (y_from == y && x_from != x || y_from != y && x_from == x) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination = false;
                                } else {
                                    System.out.println("Rook can't move like that,try again: ");
                                    break someLabel;
                                }
                            }
                            if (cells[x_from][y_from].equals("HW ") || cells[x_from][y_from].equals("HB ")) {
                                if ((Math.abs(x_from - x) == 2 && Math.abs(y_from - y) == 1) ||
                                        (Math.abs(x_from - x) == 1 && Math.abs(y_from - y) == 2)) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination = false;
                                } else {
                                    System.out.println("Hourse can't move like that,try again: ");
                                    break someLabel;
                                }
                            }
                            if (cells[x_from][y_from].equals("HW ") || cells[x_from][y_from].equals("HB ")) {
                                if ( y - y_from == 1 && x == x_from ) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination = false;
                                } else {
                                    System.out.println("Pawn can't move like that,try again: ");
                                    break someLabel;
                                }
                            }
                            if (cells[x_from][y_from].equals("KW ") || cells[x_from][y_from].equals("KB ")) {
                                if (Math.abs(x_from - x) <= 1 && Math.abs(y_from - y) <= 1) {
                                    cells[x][y] = cells[x_from][y_from];
                                    cells[x_from][y_from] = location + " ";
                                    isDestination = false;
                                } else {
                                    System.out.println("King can't move like that,try again: ");
                                    break someLabel;
                                } } } } }
                }
            chessBoard.show(cells);

            SelectionLabel: while (true) {
                System.out.println("Do you want continue or exit?(1/2)");
                vibor = reader.readLine();
                switch (vibor) {
                    case "1":
                        System.out.println("You have chosen continue" + "\n");
                        break SelectionLabel;
                    case "2":
                        System.out.println("Thanks for game...");
                        break MainLabel;
                    default:
                        System.out.println("Doesn't exist this number,try again");
                        break;
                } } }
    }
}


