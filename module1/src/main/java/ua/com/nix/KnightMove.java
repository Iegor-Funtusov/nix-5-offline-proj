package ua.com.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightMove {
    public static void horseMove() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        int y = 0;
        System.out.println("Введите начальные координаты X и Y: ");
        int X = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());

        if((X > 0 && X < 9) && (Y > 0 && Y < 9)){
            x = X;
            y = Y;
        }
        else {
            throw new Exception();
        }
        System.out.println("Введите координаты куда Вы бы хотели передвинуть коня X и Y: ");
        int Xdest = Integer.parseInt(reader.readLine());
        int Ydest = Integer.parseInt(reader.readLine());

        if ((Xdest > 0 && Xdest < 9) && (Ydest > 0 && Ydest < 9)) {

            int dX = Math.abs(X - Xdest);
            int dY = Math.abs(Y - Ydest);

            if ((dX == 1 && dY == 2) || dX == 2 && dY == 1) {
                System.out.println("Ход возможен");
            } else {
                System.out.println("Ход невозможен");
            }
        }
        else {
            throw new Exception();
        }
    }
}
