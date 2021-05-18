package ua.com.alevel.lvl3;

public class LifeGame {
    public static void lifeGame() {
    int m = 8, n = 8;

    int[][] tabl = {
            { 0, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0 },
    };

        System.out.println("@ - alive\n" +
                "# - dead\n");
    System.out.println("Original Generation");
    for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++) {
            if (tabl[i][j] == 0)
                System.out.print("#");
            else
                System.out.print("@");
        }
        System.out.println();
    }
        System.out.println();
    nextGeneration(tabl, m, n);
    }


    static void nextGeneration(int tabl[][], int M, int N) {
        int[][] nextGen = new int[M][N];
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += tabl[l + i][m + j];

                aliveNeighbours -= tabl[l][m];
                if ((tabl[l][m] == 1) && (aliveNeighbours < 2))
                    nextGen[l][m] = 0;
                else if ((tabl[l][m] == 1) && (aliveNeighbours > 3))
                    nextGen[l][m] = 0;
                else if ((tabl[l][m] == 0) && (aliveNeighbours == 3))
                    nextGen[l][m] = 1;
                else
                    nextGen[l][m] = tabl[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (nextGen[i][j] == 0)
                    System.out.print("#");
                else
                    System.out.print("@");
            }
            System.out.println();
        }
    }
}