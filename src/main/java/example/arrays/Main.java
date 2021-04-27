package example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static example.arrays.ArrayInput.input;
import static example.arrays.ShowOperations.show;

public class Main {
    public static void main(String[] args) throws IOException {
        show();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String operation;
        if (((operation = br.readLine()) != null))
            switch (operation) {
                case "1":
                    ArraysOperations.evenNumbers(input());
                    break;
                case "2":
                    ArraysOperations.countPositiveNumbers(input());
                    break;
                case "3":
                    ArraysOperations.numberLargePrevious(input());
                    break;
                case "4":
                    ArraysOperations.countNumberGreaterNeighbor(input());
                    break;
                case "5":
                    ArraysOperations.reverseArrays(input());
                    break;
                case "6":
                    ArraysOperations.swapElementsArray(input());
                    break;
                default:
                    System.out.println("Wrong operation input!!!");
                    break;
            }
    }
}

