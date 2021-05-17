package level3.gameOfLife;

public class GOLboard {
    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    private int N;
    private int M;
    private Cell[][] cells;
    private String[][] board;

    public GOLboard(int n, int m) {
        N = n;
        M = m;
        board = new String[N][M];
        cells = new Cell[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = ".";
                cells[i][j] = new Cell();
            }
        }
    }

    public void setCell(int i, int j){
        cells[i][j].setStatus(Status.LIVE);
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cells[i][j].getStatus().isCell()) {
                    board[i][j] = "#";
                } else {
                    board[i][j] = ".";
                }
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void gameOfLifeStep() {
        if (board == null || board.length == 0 || cells == null || cells.length == 0) return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!(x == 0 && y == 0) && (i + x) < N && (j + y) < M && (i + x) >= 0 && (j + y) >= 0) {
                            cells[i][j].addNear(cells[i + x][j + y]);
                        }
                    }
                }
                cells[i][j].toPrepare();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cells[i][j].replace();
            }
        }
        print();
    }

}
