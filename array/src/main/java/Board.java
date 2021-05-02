public class Board {
    Position[][] position;

    public Board() {
        this.pos();
    }

    public Position getSquare(int x, int y){
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            return position[x][y];
        }
        System.out.println("Invalid coordinates specified boundaries A-H 1-8");
        return null;
    }

    public void pos() {
        position = new Position[8][8];
        boolean temp = true;
        int i = 0;
        while (i < 8) {
            for (int j = 0; j < 8; j++) {
                position[i][j] = new Position(i, j, temp);
                temp = !temp;
            }
            temp = !temp;
            i++;
        }
    }
}
