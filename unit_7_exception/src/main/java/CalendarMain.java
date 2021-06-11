public class CalendarMain {
    public static void main(String[] args) {
        Date date1 = new Date(0,8,9,4,0,0);
        Date date2 = new Date(2021,6,11,12,1,1);


        System.out.println(DateOperations.differenceInYears(date1, date2));
        System.out.println(DateOperations.differenceInMonths(date1, date2));
        System.out.println(DateOperations.differenceInDays(date1, date2));
        System.out.println(DateOperations.differenceInHours(date1, date2));
        System.out.println(DateOperations.differenceInMinutes(date1, date2));
        System.out.println(DateOperations.differenceInSeconds(date1, date2));

        System.out.println(date1);
        System.out.println(date2);
    }
}

