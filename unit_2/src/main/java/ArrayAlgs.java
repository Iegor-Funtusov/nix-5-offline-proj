import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ArrayAlgs {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter size of array:");
        int size = Integer.parseInt(enter.readLine());
        array = new int[size];

        System.out.println("1. Enter from keyboard\n2. Enter random nums");
        int choose = Integer.parseInt(enter.readLine());

        if (choose == 1){
            fromKeyboard(array, size);
        } else if (choose == 2) {
            randElements(array, size);
        } else {
            System.out.println("Wrong input");
        }

        displayArr(array);

        System.out.println("1. Output all even numbers\n" +
                "2. Count all positive numbers\n" +
                "3. Count all numbers which are greater than the previous\n" +
                "4. Count all numbers whose neighbors are smaller\n" +
                "5. Revers array\n" +
                "6. Rearrange adjacent elements");

        choose = Integer.parseInt(enter.readLine());

        switch (choose) {
            case 1:
                allEvenNums(array, size);
                break;
            case 2:
                countPosNums(array, size);
                break;
            case 3:
                countNumsGreater(array, size);
                break;
            case 4:
                countNumsNeighborsSmall(array, size);
                break;
            case 5:
                reversArr(array, size);
                break;
            case 6:
                RearrangeArr(array, size);
                break;
        }
    }

    private static void RearrangeArr(int[] array, int size) {
        for(int i = 1; i < size; i+=2){
            int q = array[i];
            array[i] = array[i-1];
            array[i-1] = q;
        }
        displayArr(array);
    }

    private static void reversArr(int[] array, int size) {
        for (int i = 0; i < size / 2; i++) {
            int tmp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = tmp;
        }
        displayArr(array);
    }

    private static void countNumsNeighborsSmall(int[] array, int size) {
        int count = 0;
        for (int i = 1; i < size - 1; i++) {
            if (array[i] >= array[i - 1] && array[i] >= array[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void countNumsGreater(int[] array, int size) {
        int count = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] >= array[i - 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void countPosNums(int[] array, int size) {
        int count = 0;
        for (int value:
             array) {
            if (value >= 0){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void allEvenNums(int[] array, int size) {
        for (int value: array) {
            if (value % 2 == 0) {
                System.out.print(value + " ");
            }
        }
        System.out.print("\n");
    }
    

    private static void randElements(int[] array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        for (int i = random.nextInt(size) + 2; i < size; i++) {
            array[i] = random.nextInt(100) * -1;
        }
    }

    private static void fromKeyboard(int[] array, int size) {
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter elements");
        for (int i = 0; i < size; i++) {
            try {
                array[i] = Integer.parseInt(enter.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private  static void displayArr (int[] array) {
        System.out.println("Array: ");
        for (int value:
             array) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }
}
