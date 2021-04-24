import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_class {
    public static void main(String[] args) throws IOException {
        Array_class arrayClassObj = new Array_class();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите длину массива: ");
        int numForInput = Integer.parseInt(reader.readLine());
        System.out.print("Заполните массив через Space и нажмите Enter: ");
        String lines = reader.readLine();
        String[] strs = lines.trim().split("\\s+");
        int[] array = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

        arrayClassObj.first(array);
        arrayClassObj.second(array);
        arrayClassObj.third(array);
        arrayClassObj.fourth(array);

    }

    public void first(int[] array) {
        System.out.println("Task 1");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public void second(int[] array) {
        System.out.println("Task 2");
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void third(int[] array) {
        System.out.println("Task 3");
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void fourth(int[] array){
        System.out.println("Task 4");
        int count = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if(array[i-1] < array[i] && array[i] > array[i+1]){
                count++;
            }
        }
        System.out.println(count);
    }

}