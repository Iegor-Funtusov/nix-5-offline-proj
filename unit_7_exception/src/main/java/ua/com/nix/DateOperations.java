package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DateOperations {
    Date date = new Date();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Date> dateList = new ArrayList<>(15);

    public void parse(String datePart, Date date) {
        if (datePart.equals("/")) {
            String[] dateParts = datePart.split("/");
            for (int i = 0; i < dateParts.length; i++) {
                if (dateParts[i].isEmpty())
                    dateParts[i] = "1";
            }
            date.setDay(Integer.parseInt(dateParts[0]));
            date.setMonth(Integer.parseInt(dateParts[1]));
            if (dateParts.length < 3) {
                date.setYear(2021);
            } else {
                date.setYear(Integer.parseInt(dateParts[2]));
            }
        } else {
            date.setYear(Integer.parseInt(datePart));
        }
    }

    public void createDate() {
        try {

            String dateRead = reader.readLine();
            int emptyIndex = dateRead.indexOf(" ");

            if (emptyIndex >= 3) {
                String datePart = dateRead.substring(0, emptyIndex);
                parse(datePart, date);
                String[] timeParts = datePart.split(":");
                if (timeParts.length < 3) {
                    date.setMinute(Integer.parseInt(timeParts[0]));
                    date.setSecond(Integer.parseInt(timeParts[1]));
                } else {
                    date.setHour(Integer.parseInt(timeParts[0]));
                    date.setMinute(Integer.parseInt(timeParts[1]));
                    date.setSecond(Integer.parseInt(timeParts[2]));
                }

            } else {
                parse(dateRead, date);
            }
            dateList.add(date);
        } catch (IOException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Извините, введите корректные данные");
            createDate();
        }
    }

    public void add() {
        System.out.println("Введите дату: Формат: 1/10/34 или /5/47 или /2/ или 1256 59:59");
        createDate();

        while (true) {
            System.out.println("Введите действие для добавления к дате: \n" +
                    "1 - Секунд\n" +
                    "2 - Минут\n" +
                    "3 - Часов\n" +
                    "4 - Дней\n" +
                    "5 - Месяцев\n" +
                    "6 - Годов\n" +
                    "0 - Выйти в главное меню.");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String read = reader.readLine();

                switch (read) {
                    case "1": {
                        System.out.println("Введите секунды для добавления: ");
                        int second = Integer.parseInt(reader.readLine());
                        addSecond(dateList, second);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "2": {
                        System.out.println("Введите минуты для добавления: ");
                        int minute = Integer.parseInt(reader.readLine());
                        addMinute(dateList, minute);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "3": {
                        System.out.println("Введите часы для добавления: ");
                        int hour = Integer.parseInt(reader.readLine());
                        addHour(dateList, hour);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "4": {
                        System.out.println("Введите дни для добавления: ");
                        int day = Integer.parseInt(reader.readLine());
                        addDay(dateList, day);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "5": {
                        System.out.println("Введите месяцы для добавления: ");
                        int month = Integer.parseInt(reader.readLine());
                        addMonth(dateList, month);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "6": {
                        System.out.println("Введите годы для добавления: ");
                        int year = Integer.parseInt(reader.readLine());
                        addYear(dateList, year);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "0": {
                        dateList.clear();
                        System.exit(0);
                        break;
                    }
                }
            } catch (IOException | IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public void minus() {
        System.out.println("Введите дату: Формат: 1/10/34 или /5/47 или /2/ или 1256 59:59");

        while (true) {
            System.out.println("Введите действие для вычетания даты: \n" +
                    "1 - Секунды\n" +
                    "2 - Минуты\n" +
                    "3 - Часы\n" +
                    "4 - Дни\n" +
                    "5 - Месяцы\n" +
                    "6 - Годы\n" +
                    "0 - Выйти в главное меню.");
            try {
                String read = reader.readLine();
                switch (read) {
                    case "1": {
                        System.out.println("Введите секунды для минуса даты:");
                        int seconds = Integer.parseInt(reader.readLine());
                        minusSeconds(dateList, seconds);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "2": {
                        System.out.println("Введите минуты для минуса даты: ");
                        int minutes = Integer.parseInt(reader.readLine());
                        minusMinutes(dateList, minutes);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "3": {
                        System.out.println("Введите часы для минуса даты: ");
                        int hours = Integer.parseInt(reader.readLine());
                        minusHours(dateList, hours);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "4": {
                        System.out.println("Введите дни для минуса даты: ");
                        int days = Integer.parseInt(reader.readLine());
                        minusDays(dateList, days);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "5": {
                        System.out.println("Введите месяцы для минуса даты: ");
                        int month = Integer.parseInt(reader.readLine());
                        minusMonth(dateList, month);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "6": {
                        System.out.println("Введите годы для минуса даты:");
                        int years = Integer.parseInt(reader.readLine());
                        minusYear(dateList, years);
                        System.out.println(dateList.get(0));
                        break;
                    }
                    case "0": {
                        dateList.clear();
                        System.exit(0);
                        break;
                    }
                }
            }
            catch (IOException | IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public void difference() {

        String starter = null;
        int iter = 1;

        while (iter <= 2) {

            System.out.println("Введите дату: Формат: 1/10/34 или /5/47 или /2/ или 1256 59:59");
            System.out.println("Введена " + iter + " дата: ");
            iter++;

        }

        while (true) {
            for (Date date1 : dateList) {
                System.out.println(date1);
            }
            System.out.println("Введите действие для нахождения разницы дат в: \n" +
                    "1 - Секундах\n" +
                    "2 - Минутах\n" +
                    "3 - Часах\n" +
                    "4 - Днях\n" +
                    "5 - Месяцах\n" +
                    "6 - Годах\n" +
                    "0 - Выйти в главное меню.");

            String read = reader.readLine();
            switch (read) {
                case "1": {
                    System.out.println("Разница в секундах:  " + differenceInSeconds());
                    break;
                }
                case "2": {
                    System.out.println("Разница в минутах: " + differenceInMinutes());
                    break;
                }
                case "3": {
                    System.out.println("Разница в часах: " + differenceInHours());
                    break;
                }
                case "4": {
                    System.out.println("Разница в днях: " + differenceInDay());
                    break;
                }
                case "5": {
                    System.out.println("Разница в месяцах: " + differenceInMonth());
                    break;
                }
                case "6": {
                    System.out.println("Разница в годах: " + differenceInYear());
                    break;
                }
                case "0": {
                    dateList.clear();
                    break;
                }
            }
        }
    }

    public void addYear(ArrayList<Date> dateList, int year) {
        if (year > 0) {
            dateList.get(0).setYear(dateList.get(0).getYear() + year);
        } else {
            System.out.println("Вы ввели неправильные данные.");
        }
    }

    public void addDay(ArrayList<Date> dateList, int day) {
        if (day > 0) {
            int index = date.getDaysInMonth(dateList.get(0).getMonth(),
                    dateList.get(0).getYear());
            if (index < day) {
                day -= index - dateList.get(0).getDay() + 1;
                dateList.get(0).setDay(1);
                try {
                    dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                } catch (IllegalArgumentException e) {
                    dateList.get(0).setMonth(1);
                    dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                }
                while (day >= 365) {
                    if (dateList.get(0).getYear() % 4 == 0 && day > 365) {
                        dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                        day -= 366;
                    } else if (dateList.get(0).getYear() % 4 != 0 && day >= 365) {
                        dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                        day -= 365;
                    }
                }
                while (day >= 28) {
                    index = date.getDaysInMonth(dateList.get(0).getMonth(),
                            dateList.get(0).getYear());
                    if (index <= day) {
                        try {
                            dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                        } catch (IllegalArgumentException e) {
                            dateList.get(0).setMonth(1);
                            dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                        }
                        day -= index;
                    } else
                        break;
                }
            }
            index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
            for (int i = dateList.get(0).getDay(); i <= (index + 1); i++) {
                if (day != 0) {
                    try {
                        dateList.get(0).setDay(dateList.get(0).getDay() + 1);
                    } catch (IllegalArgumentException argDays) {
                        dateList.get(0).setDay(1);
                        try {
                            dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                        } catch (IllegalArgumentException argMonth) {
                            dateList.get(0).setMonth(1);
                            dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                        }
                    }
                    day--;
                }
            }
            if (day != 0)
                dateList.get(0).setDay(dateList.get(0).getDay() + day);
        } else {
            System.out.println("Неправильные данные");
        }
    }

    public void addHour(ArrayList<Date> dateList, int hour) {
        if (hour > 0) {
            if (hour >= 24) {
                addDay(dateList, hour / 24);
                dateList.get(0).setHour(hour % 24);
            } else {
                dateList.get(0).setHour(dateList.get(0).getHour() + hour % 24);
                if (dateList.get(0).getHour() >= 24) {
                    dateList.get(0).setHour(dateList.get(0).getHour() - 24);
                    try {
                        dateList.get(0).setDay(dateList.get(0).getDay() + 1);
                    } catch (IllegalArgumentException argDays) {
                        if (dateList.get(0).getHour() == 24)
                            dateList.get(0).setHour(0);
                        if (dateList.get(0).getDay() >
                                date.getDaysInMonth(dateList.get(0).getMonth(),
                                        dateList.get(0).getYear())) {
                            dateList.get(0).setDay(1);
                            try {
                                dateList.get(0).setMonth(dateList.get(0).getMonth() + 1);
                            } catch (IllegalArgumentException e) {
                                dateList.get(0).setMonth(1);
                                dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Неправильные данные");
        }
    }

    public void addMinute(ArrayList<Date> dateList, int minute) {
        if (minute > 0) {
            int newMinutes = dateList.get(0).getMinute() + minute;
            if (newMinutes > 59) {
                dateList.get(0).setMinute(newMinutes % 60);
                addHour(dateList, newMinutes / 60);
            } else {
                dateList.get(0).setMinute(newMinutes);
            }
        } else {
            System.out.println("Неправильные данные.");
        }
    }

    public void addMonth(ArrayList<Date> dateList, int month) throws IOException {
        if (month > 0) {
            if (month / 12 > 0) {
                dateList.get(0).setYear(dateList.get(0).getYear() + (month / 12));
                if (month % 12 + dateList.get(0).getMonth() <= 12) {
                    dateList.get(0).setMonth(dateList.get(0).getMonth() + month % 12);
                }
            } else {
                dateList.get(0).setYear(dateList.get(0).getYear() + 1);
                dateList.get(0).setMonth(month - (12 - dateList.get(0).getMonth()));
            }
        } else {
            System.out.println("Неправильные данные.");
        }
    }

    public void addSecond(ArrayList<Date> dateList, int second) throws IOException {
        if (second > 0) {
            int newSecond = dateList.get(0).getSecond() + second;
            if (newSecond > 59) {
                dateList.get(0).setMinute(newSecond % 60);
                addMinute(dateList, newSecond / 60);
            } else {
                dateList.get(0).setMinute(newSecond);
            }
        } else {
            System.out.println("Неправильные данные");
        }
    }

    public int differenceInMonth(){
        return (Math.abs(dateList.get(0).getMonth() - dateList.get(1).getMonth()) +
                (Math.abs(dateList.get(0).getYear() - dateList.get(1).getYear())* 12));
    }
    
    public int differenceInSeconds(){
        return (Math.abs(dateList.get(0).getSecond() - dateList.get(1).getSecond()) + differenceInMinutes() * 60);
    }

    public int differenceInMinutes(){
        return (Math.abs(dateList.get(0).getMinute() - dateList.get(1).getMinute()) + differenceInHours() * 60);
    }

    public int differenceInHours(){
        return (Math.abs(dateList.get(0).getHour() - dateList.get(1).getHour()) + differenceInDay() * 24);
    }

    public int differenceInDay(){
        return (Math.abs(dateList.get(0).getDay() - dateList.get(1).getDay()) + forDifferenceInDay());
    }

    public int differenceInYear(){
        return Math.abs(dateList.get(0).getYear() - dateList.get(1).getYear());
    }

    public int forDifferenceInDay() {
        int[] ALL_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        int monthForDiff1 = dateList.get(0).getMonth();
        int monthForDiff2 = dateList.get(1).getMonth();
        int count = Math.abs(monthForDiff1 - monthForDiff2);

        int index = Math.min(dateList.get(0).getMonth(),dateList.get(1).getMonth());
        int firstYear = dateList.get(0).getYear();
        int differYear = differYear();

        while (differYear > 0) {
            if (++firstYear % 4 == 0) {
                days += 366;
            } else {
                days += 365;
            }
            differYear--;
        }
        for (int i = 0; i < count; i++) {
            days += ALL_DAYS[index];
            index++;
        }
        return days;
    }

    private void minusYear(ArrayList<Date> dateList, int years) {
        if (years > 0) {
            dateList.get(0).setYear(dateList.get(0).getYear() - years);
        } else
            System.out.println("Извините, вы ввели неправильные данные");
    }

    private void minusMonth(ArrayList<Date> dateList, int month) {
        if (month > 0) {
            if (month / 12 > 0) {
                dateList.get(0).setYear(dateList.get(0).getYear() - (month / 12));
                if (month % 12 > dateList.get(0).getMonth()) {
                    month = dateList.get(0).getMonth();
                    dateList.get(0).setMonth( 12 - month);
                    dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                }
                else {
                    dateList.get(0).setMonth(dateList.get(0).getMonth() - month % 12);
                    if(dateList.get(0).getMonth() == 0) {
                        dateList.get(0).setMonth(12);
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    }
                }
            }
        } else {
            System.out.println("Извините, вы ввели неправильные данные");
        }
    }

    private void minusDays(ArrayList<Date> dateList,int days) {
        if (days > 0) {
            int index;
            if(dateList.get(0).getDay() <= days ) {
                days -= dateList.get(0).getDay();
                try {
                    dateList.get(0).setMonth(dateList.get(0).getMonth() - 1);
                } catch (IllegalArgumentException e) {
                    dateList.get(0).setMonth(12);
                    dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                }
                dateList.get(0).setDay(date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear()));
            }
            else {
                dateList.get(0).setDay(dateList.get(0).getDay() - days);
                return;
            }

            while (days >= 365) {
                if (dateList.get(0).getYear() % 4 == 0 && days > 365) {
                    dateList.get(0).setYear(dateList.get(0).getYear()-1);
                    days -= 366;
                } else if (dateList.get(0).getYear() % 4 != 0 && days >= 365) {
                    dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    days -= 365;
                }
            }
            while (days >= 28) {
                index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
                if (index <= days) {
                    try {
                        dateList.get(0).setMonth(dateList.get(0).getMonth()-1);
                    }
                    catch (IllegalArgumentException e) {
                        dateList.get(0).setMonth(12);
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                    }
                    days -= index;
                } else {
                    break;
                }
            }
            index = date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear());
            dateList.get(0).setDay(index - days);
        }
        else {
            System.out.println("Извините, вы ввели неправильные данные");
        }
    }

    private void minusHours(ArrayList<Date> dateList, int hours) {
        if (hours > 0) {
            if (hours >= dateList.get(0).getHour()) {
                hours = hours - dateList.get(0).getHour();
                dateList.get(0).setHour(0);
            } else {
                dateList.get(0).setHour(dateList.get(0).getHour() - hours);
            }
            if (0 < hours / 24) {
                minusDays(dateList, hours / 24);
                try {
                    dateList.get(0).setHour(24 - hours % 24);
                } catch (IllegalArgumentException hour) {
                    dateList.get(0).setHour(0);
                }
                try {
                    dateList.get(0).setDay(dateList.get(0).getDay() - 1);
                } catch (IllegalArgumentException days) {
                    try {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() - 1);
                    } catch (IllegalArgumentException months) {
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                        dateList.get(0).setMonth(12);
                    }
                    dateList.get(0).setDay(date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear()));
                }
            } else {
                try {
                    dateList.get(0).setHour(24 - hours);
                } catch (IllegalArgumentException hour) {
                    dateList.get(0).setHour(0);
                }
                try {
                    dateList.get(0).setDay(dateList.get(0).getDay() - 1);
                } catch (IllegalArgumentException days) {
                    try {
                        dateList.get(0).setMonth(dateList.get(0).getMonth() - 1);
                    } catch (IllegalArgumentException months) {
                        dateList.get(0).setYear(dateList.get(0).getYear() - 1);
                        dateList.get(0).setMonth(12);
                    }
                    dateList.get(0).setDay(date.getDaysInMonth(dateList.get(0).getMonth(), dateList.get(0).getYear()));
                }
            }
        }
        else {
            System.out.println("Извините, вы ввели неправильные данные");
        }
    }
    private void minusMinutes(ArrayList<Date> dateList, int minutes) {
        if(minutes > 0) {
            int tempMinutes = dateList.get(0).getMinute();
            int newMinutes = tempMinutes - minutes;
            if(newMinutes <= 0)
            {
                try {
                    dateList.get(0).setMinute(60 + (newMinutes % 60));
                } catch (IllegalArgumentException min) {
                    dateList.get(0).setMinute(0);
                }
                if ((tempMinutes+minutes) % 60 == 0) {
                    minusHours(dateList, 1);
                }
                else {
                    minusHours(dateList, (tempMinutes + minutes + 60) / 60);
                    if (dateList.get(0).getHour() == 24) {
                        dateList.get(0).setHour(0);
                    }
                }
            } else {
                dateList.get(0).setMinute(newMinutes);
            }
        }
        else {
            System.out.println("Извините, вы ввели неправильные данные");
        }
    }

    private void minusSeconds(ArrayList<Date> dateList, int seconds) {
        if (seconds > 0) {
            int temp = dateList.get(0).getSecond();
            int newSeconds = temp - seconds;
            if (newSeconds <= 0) {
                try {
                    dateList.get(0).setSecond(60 + (newSeconds % 60));
                } catch (IllegalArgumentException min) {
                    dateList.get(0).setSecond(0);
                }
                if ((temp + seconds) % 60 == 0) {
                    minusMinutes(dateList, 1);
                }
            } else {
                minusMinutes(dateList, (temp + seconds + 60) / 60);
                if (dateList.get(0).getMinute() == 24) {
                    dateList.get(0).setSecond(0);
                }
            }
        } else {
            System.out.println("Извините, вы ввели неправильные данные");
        }
    }
}
