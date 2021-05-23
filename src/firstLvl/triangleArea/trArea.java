package firstLvl.triangleArea;

import java.util.Scanner;

public class trArea {

    public static void trAreaa() {
        Scanner input = new Scanner(System.in);
        int size=9;
        double array[] = new double[size];
        System.out.println("Введите координаты точок ABC");
        System.out.println("A: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
            if(i==2){
                System.out.println("B: ");
            }
            if(i==5){
                System.out.println("C: ");
            }
        }


        System.out.println("P = " );
        double ab = Math.sqrt(Math.pow((array[3]-array[0]),2)+Math.pow(array[4]-array[1],2)+ Math.pow(array[5]-array[2],2));
        double ac = Math.sqrt(Math.pow((array[6]-array[0]),2)+Math.pow(array[7]-array[1],2)+Math.pow(array[8]-array[2],2));
        double bc = Math.sqrt(Math.pow((array[6]-array[3]),2)+Math.pow(array[7]-array[4],2)+Math.pow(array[8]-array[5],2));
        double p=(ab+bc+ac)/2;
        System.out.println("P = " + p);
        double s = Math.sqrt(p*(p-ab)*(p-bc)*(p-ac));
        System.out.println("Площа равна: = " + s);


    }
}
