package ua.com.nix.task1;

public class Date {

    private final String day;
    private final String month;
    private final String year;

    public Date(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }


    @Override
    public String toString() {
        System.out.println("__________");
        return "|" + day + "" + month + "" + year + "|";
    }
}
