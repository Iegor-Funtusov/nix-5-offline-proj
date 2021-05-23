import firstLvl.ChessKnight.Chess;
import firstLvl.UnicChisla.UnicChisla;
import firstLvl.triangleArea.trArea;
import secondLvl.Scobki;
import thirdLvl.OurGameLife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean aa = true;
        while (true) {
            System.out.println("Выберите уровень");
            Scanner lvl = new Scanner(System.in);
            int a = lvl.nextInt();
            if (a == 1) {
                while (aa==true) {
                    System.out.println("Выберите задачу");
                    int b = lvl.nextInt();
                    if (b == 1) {
                        UnicChisla.unicChislaa();
                    }
                    if (b == 2) {
                        Chess.chessKnight();
                    }
                    if (b == 3) {
                        trArea.trAreaa();
                    }
                    System.out.println("1- Перейти к выбору уровня");
                    System.out.println("2- Перейти к выбору задачи");
                    int vibor = lvl.nextInt();
                    if(vibor==1){
                        aa=false;
                    }
                }
            }
            if (a == 2) {
                Scobki.rightsScobki();
            }
            if (a == 3) {
                OurGameLife.startGameLife();
            }
        }
    }
}