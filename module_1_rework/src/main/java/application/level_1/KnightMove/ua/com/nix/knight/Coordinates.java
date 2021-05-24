package application.level_1.KnightMove.ua.com.nix.knight;

public class Coordinates {
    public char x;
    public int y;

    public Coordinates(String str){
        this.x = str.toLowerCase().charAt(0);
        this.y = Integer.parseInt(str.substring(1));
        if(x < 'a' || x > 'h'){
            throw new RuntimeException("Неправильная буква");
        }
        if(y < 1 || y > 8){
            throw new RuntimeException("Неправильная цифра");
        }
    }
}