public class ChessFigure {
    private Figures type;
    private Coordinates coordinates;

    public ChessFigure(Figures type, Coordinates coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public void setType(Figures type) {
        this.type = type;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Figures getType() {
        return type;
    }

    public void move(){

    }


}
