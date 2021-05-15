package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightMove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите начальные координаты X и Y: ");
        int X = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());
        System.out.println("Введите координаты куда Вы бы хотели передвинуть коня X и Y: ");
        int Xdest = Integer.parseInt(reader.readLine());
        int Ydest = Integer.parseInt(reader.readLine());
        int dX = Math.abs(X - Xdest);
        int dY = Math.abs(Y - Ydest);
        if ((dX == 1 && dY == 2) || dX == 2 && dY == 1){
            System.out.println("Ход возможен");
        }
        else {
            System.out.println("Ход невозможен");
        }

    }
}
