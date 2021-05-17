package level3.gameOfLife;

public class GOLboard {
    private int N;
    private int M;
    private Cell[][] cels;
    private String[][] board;

    public GOLboard(int n, int m) {
        N = n;
        M = m;
        board = new String[N][M];
        cels = new Cell[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = ".";
                cels[i][j] = new Cell();
            }
        }
        cels[5][3].setStatus(Status.LIVE);
        cels[5][4].setStatus(Status.LIVE);
        cels[5][5].setStatus(Status.LIVE);
        cels[4][4].setStatus(Status.LIVE);
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cels[i][j].getStatus().isCell()) {
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
        if (board == null || board.length == 0 || cels == null || cels.length == 0) return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!(x == 0 && y == 0) && (i + x) < N && (j + y) < M && (i + x) >= 0 && (j + y) >= 0) {
                            cels[i][j].addNear(cels[i + x][j + y]);
                        }
                    }
                }
                cels[i][j].toPrepare();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cels[i][j].replace();
            }
        }
        print();
    }

}
