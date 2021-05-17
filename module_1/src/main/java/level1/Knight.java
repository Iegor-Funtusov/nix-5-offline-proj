package level1;

public class Knight {

    private int posX, posY;

    public void move(int x, int y){
        if (checkMove(x, y))
            setPos(x, y);
    }

    public boolean checkMove(int x, int y){
        return  (x >= 1 && x <=8 && y >= 1 && y <= 8) &&
                ((Math.abs(posX - x) == 1 && Math.abs(posY - y) == 2) ||
                (Math.abs(posX - x) == 2 && Math.abs(posY - y) == 1));
    }

    public int getPosX() {
        return posX;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }
}
