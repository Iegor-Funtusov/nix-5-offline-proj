package nix.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("Enter needed type of set(1 - Integer; 2 - Double)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choose = null;
        while (true) {
            try {
                choose = reader.readLine();
                Integer.parseInt(choose);
                break;
            } catch (IOException e) {
                e.printStackTrace();
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
