public class ChessBoard {
    String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String [][] arr = new String[8][8];
    public String[][] create(){
        for (int i = letter.length - 1; i >= 0; i--) {
            for (int j = 0; j < letter.length; j++) {
                arr[i][j] = (letter[j] + (i + 1) + " ");
            }
        }
        return arr;
    }
    public void show(String[][] arr)
    {
        for (int i = arr.length-1; i>=0; i--) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
