public class ChessFigure {

    FigureType figureType;
    private int posX, posY;

    ChessFigure(FigureType type) {
        this.figureType = type;
    }

    public void move(int x, int y){
        if (checkMove(x, y))
            setPos(x, y);
    }

    public boolean pawnMove(int x, int y) {
        return (posY - y) == 1 && posX == x;
    }

    public boolean bishopMove(int x, int y) {
        return Math.abs(posX - x) == Math.abs(posY - y);
    }

    public boolean knightMove(int x, int y) {
        return (Math.abs(posX - x) == 1 && Math.abs(posY - y) == 2) ||
                (Math.abs(posX - x) == 2 && Math.abs(posY - y) == 1);
    }

    public boolean rookMove(int x, int y) {
        return x == posX || y == posY;
    }

    public boolean queenMove(int x, int y) {
        return (Math.abs(posX - x) == Math.abs(posY - y)) ||
                (x == posX || y == posY);
    }

    public boolean kingMove(int x, int y) {
        return Math.abs(posX - x) <= 1 && Math.abs(posY - y) <= 1;
    }

    public boolean checkMove(int x, int y){
        if (x >= 1 && x <=8 && y >= 1 && y <= 8){
            switch (this.figureType) {
                case WHITE_PAWN:
                case BLACK_PAWN:
                    return pawnMove(x, y);
                case WHITE_BISHOP:
                case BLACK_BISHOP:
                    return bishopMove(x, y);
                case WHITE_KNIGHT:
                case BLACK_KNIGHT:
                    return knightMove(x, y);
                case WHITE_ROOK:
                case BLACK_ROOK:
                    return rookMove(x, y);
                case WHITE_QUEEN:
                case BLACK_QUEEN:
                    return queenMove(x, y);
                case WHITE_KING:
                case BLACK_KING:
                    return kingMove(x, y);
                default:
                    return false;
            }
        }
        return false;
    }

    public void setPos(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            this.posX = x;
            this.posY = y;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public FigureType getFigureType() {
        return figureType;
    }
}
