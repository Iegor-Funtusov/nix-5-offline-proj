package example.arithmetick;

public class ArraysOperations {

    public static void evenNumbers(int[] arr) {
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void countPositiveNumbers(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void numberLargePrevious(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void countNumberGreaterNeighbor(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i + 1] > arr[i]) && (arr[i + 1] > arr[i + 2])) {
                count++;
            }
        }
        System.out.print(count);
    }

   public static void reverseArrays(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void swapElementsArray(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i += 2) {
            temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
       for (int i : arr){
           System.out.print(i + " ");
       }
    }
}
