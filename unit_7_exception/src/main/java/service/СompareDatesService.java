package service;

import java.util.Comparator;

import static dao.CreateDateService.calendarList;

public class СompareDatesService {
    public void sortAscending() {
        calendarList.sort(CalendarService::compareTo);
        calendarList.forEach(System.out::println);
    }

    public void sortDescending() {
        calendarList.sort(Comparator.reverseOrder());
        calendarList.forEach(System.out::println);
    }
}
