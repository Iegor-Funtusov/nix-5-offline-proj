package level1.knight_turn;

public class Field {
   public Knight[][] field = new Knight[8][8];

    public static Knight[][] gameStart() {
        Field game = new Field();
        Knight[][] fields = renderField(game.populateField());
        return fields;
    }

    private Knight[][] populateField() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Knight knight = new Knight();
                field[i][j] = knight;
                knight.setEmpty(true);
            }
        }
        return field;
    }

    public static Knight[][] renderField(Knight[][] cells) {
        StringBuilder topLine = new StringBuilder("___|");
        for (int i = 0; i < cells.length; i++) {
            topLine.append("_").append(i).append("_|");
        }
        System.out.println(topLine.toString());
        for (int i = 0; i < cells.length; i++) {
            StringBuilder line = new StringBuilder("_" + (i) + "_|");
            for (int j = 0; j < cells[i].length; j++) {
                line.append("_").append(cells[i][j]).append("_|");
            }
            System.out.println(line.toString());
        }
        return cells;
    }
}
