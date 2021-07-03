package ua.com.nix.task1;

public class DateUtil {

    public static String[] parseDate(String inputDate) {

        String[] dateParts;
        String[] newDateParts = new String[3];
        if (inputDate.contains("/")) {
            dateParts = inputDate.split("/");
        }
        else if (inputDate.contains("-")) {
            dateParts = inputDate.split("-");
        }
        else {
            throw new IllegalArgumentException("Sorry, invalid format. Try again.");
        }

         boolean FirstDateFormat = dateParts[0].length() == 4 && dateParts[1].length() == 2 && dateParts[2].length() == 2;
         boolean SecondDateFormat = dateParts[0].length() == 2 && dateParts[1].length() == 2 && dateParts[2].length() == 4
                 && inputDate.contains("/");
         boolean ThirdDateFormat = dateParts[0].length() == 2 && dateParts[1].length() == 2 && dateParts[2].length() == 4
                 && inputDate.contains("-");

         if (FirstDateFormat) {
             newDateParts[0] = dateParts[0];
             newDateParts[1] = dateParts[1];
             newDateParts[2] = dateParts[2];
         }
         else if (SecondDateFormat) {
             newDateParts[0] = dateParts[2];
             newDateParts[1] = dateParts[1];
             newDateParts[2] = dateParts[0];
         }
         else if (ThirdDateFormat) {
             newDateParts[0] = dateParts[2];
             newDateParts[1] = dateParts[0];
             newDateParts[2] = dateParts[1];
         }

         return newDateParts;
    }
}
