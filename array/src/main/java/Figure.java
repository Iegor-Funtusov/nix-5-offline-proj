public abstract class Figure {

    private boolean colour;
    private Position position;

    public Figure() {
    }

    public boolean colour() {
        return colour;
    }

    public void setColour(boolean isWhite) {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
