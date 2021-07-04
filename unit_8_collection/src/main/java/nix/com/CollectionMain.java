package nix.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectionMain {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choose;
        while (true) {
            try {
                System.out.println("Enter needed type of set(1 - Integer; 2 - Double)");
                choose = reader.readLine();
                Integer.parseInt(choose);
                if (Integer.parseInt(choose) > 2 || Integer.parseInt(choose) < 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
        switch(Integer.parseInt(choose)) {
            case 1:
                try {
                    new IntefaceInt();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    new IntefaceDouble();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
