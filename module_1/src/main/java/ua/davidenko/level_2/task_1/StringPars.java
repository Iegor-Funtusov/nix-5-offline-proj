package ua.davidenko.level_2.task_1;

public class StringPars {

    public static boolean parsForBracket(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (check < 0) {
                //return false;
            }
            String charBrack = str.substring(i, i + 1);
            if (charBrack.equals("(") || charBrack.equals("{") || charBrack.equals("[")) {
                check++;
                continue;
            }
            if (charBrack.equals(")") || charBrack.equals("}") || charBrack.equals("]"))
                check--;
        }
        if (check == 0) {
            System.out.println("String is Valid");
            return true;
        } else {
            System.out.println("String is inValid");
            return false;
        }
    }
}

