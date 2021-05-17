import level3.gameOfLife.GOLboard;

import java.io.IOException;

public class ModuleMain {
    public static void main(String[] args) throws IOException {
        GOLboard board = new GOLboard(10,10);
        board.print();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
        board.gameOfLifeStep();
    }
}
