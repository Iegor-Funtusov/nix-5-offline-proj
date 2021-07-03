package ua.com.nix.task1;

public class DetectorSplitSymbol {

    public static boolean isValidFormat(String inputString, char symbol){

        char[] symbols = inputString.toCharArray();

        int counter = 0;
        for (char c : symbols) {
            if(c == symbol){
                counter++;
            }
        }

        return counter == 2;
    }
}
