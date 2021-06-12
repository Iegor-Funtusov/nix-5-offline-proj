public class CalendarMain {
    public static void main(String[] args) {
        Date date1 = new Date(0,8,9,4,0,0);
        Date date2 = new Date(2021,6,11,12,1,1);
        System.out.println(date1);
        System.out.println(date2);

        System.out.println(DateOperations.differenceInYears(date1, date2));
        System.out.println(DateOperations.differenceInMonths(date1, date2));
        System.out.println(DateOperations.differenceInDays(date1, date2));
        System.out.println(DateOperations.differenceInHours(date1, date2));
        System.out.println(DateOperations.differenceInMinutes(date1, date2));
        System.out.println(DateOperations.differenceInSeconds(date1, date2));
        System.out.println();
        System.out.println(DateOperations.addYear(date1,2020));
        System.out.println(DateOperations.addMonth(date1,16));
        System.out.println(DateOperations.addDay(date1,382));
        System.out.println(DateOperations.addHour(date1,121));
        System.out.println(DateOperations.addMinute(date1,1000));
        System.out.println(DateOperations.addSecond(date1,8399));
        System.out.println(DateOperations.addSecond(date1,1));

    }
}

