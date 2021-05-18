package level1.knight_turn;

public class Game {
    int thisX;
    int thisY;

//    public static void game() {
//        Field field = new Field();
//        Knight[][] cells = Field.gameStart();
//        Game game = new Game();
//        game.placeKnight(cells,1,2);
//        System.out.println();
//        Field.renderField(cells);
//    }


    public Knight[][] placeKnight(Knight[][] cells, int X, int Y) {
        if (checkCoordinates(X, Y)) {
            cells[Y][X].setEmpty(false);
            thisX = X;
            thisY = Y;
            return cells;
        } else {
            return cells;
        }
    }

    public Knight[][] moveKnight(Knight[][] cells, int X, int Y) {
        if (checkCoordinates(X, Y)) {
            if (checkMove(X, Y)) {
                cells[Y][X].setEmpty(false);
                cells[thisY][thisX].setEmpty(true);
                thisX = X;
                thisY = Y;
                return cells;
            } else {
                System.out.println("Bad coordinates");
                return cells;
            }
        } else {
            return cells;
        }
    }

    private boolean checkMove(int X, int Y) {
        final int dX = Math.abs(thisX - X);
        final int dY = Math.abs(thisY - Y);

        return ((dX == 1 && dY == 2) || dX == 2 && dY == 1);
    }

    private boolean checkCoordinates(int X, int Y) {
        return X >= 0 && X < 8 && Y >= 0 && Y < 8;
    }

}
