package dataclasses;

import exception.InvalidDateFormatException;
import utils.CONSTANTS;

public class Calendar {

    private Date date;

    public Calendar() {
    }

    public Calendar(Date date) {
        this.date = date;
    }

    public Calendar(String date, String format) throws InvalidDateFormatException {
        this.date = new Date();
        this.dateParser(date, format);
    }

    public Calendar(String date, String time, String format) throws InvalidDateFormatException {
        this.date = new Date();
        this.dateParser(date, time, format);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static long getTimeDifference(Date date, Date date_) {
        return date_.getTime() - date.getTime();
    }

    public long computeTime() {
        for (int i = 0; i < this.date.getYear(); i++) {
            if (isLeapYear(i)) {
                this.date.time += 366 * 86400;
            } else {
                this.date.time += 365 * 86400;
            }
        }
        for (int i = 1; i < this.date.getMonth(); i++) {
            if (i == 2 && isLeapYear(this.date.getYear())) {
                this.date.time += 86400;
            }
            this.date.time += CONSTANTS.monthsMap.get(i) * 86400;
        }
        this.date.time += (this.date.getDate()) * 86400L;
        return this.date.time;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private void dateParser(String date_, String format) throws InvalidDateFormatException {
        String[] con = new String[3];
        String[] val = new String[3];

        if (format.contains("/")) {
            con = format.trim().split("/");
            val = date_.trim().split("/");
        } else if (format.contains("-")) {
            con = format.trim().split("-");
            val = date_.trim().split("-");
        }
        if (con.length == 1) {
            con = format.split("-");
            val = date_.split("-");
        }

        if (format.equals("dd/mm/yy")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "mm":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        case "dd":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
        }

        if (format.equals("m/d/yyyy")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "m":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        case "d":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yyyy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
        }

        if (format.equals("mmm-d-yy")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "mmm":
                            this.date.setMonth(CONSTANTS.monthsMapNames.get(val[i]));
                            break;
                        case "d":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
        }

        if (format.equals("/m/")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "":
                            this.date.setDate(1);
                            this.date.setYear(0);
                            break;
                        case "m":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
        }

        dateFormatCheck();
    }

    private void dateParser(String date_, String time, String format) throws InvalidDateFormatException {
        String[] con = new String[3];
        String[] val = new String[3];

        String formatD = format.substring(0, format.indexOf(" "));
        if (format.contains("/")) {
            con = formatD.trim().split("/");
            val = date_.trim().split("/");
        } else if (format.contains("-")) {
            con = formatD.trim().split("-");
            val = date_.trim().split("-");
        }
        if (con.length == 1) {
            con = formatD.split("-");
            val = date_.split("-");
        }

        String formatT = format.substring(format.indexOf(" ") + 1);
        String[] conT = formatT.trim().split(":");
        String[] valT = time.trim().split(":");

        if (format.equals("dd-mm-yyyy hh:mm:ss")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "mm":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        case "dd":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yyyy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
            try {
                for (int i = 0; i < conT.length; i++) {
                    switch (conT[i].toLowerCase()) {
                        case "hh":
                            this.date.setTime(Integer.parseInt(valT[i]) * 3600L);
                            break;
                        case "mm":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]) * 60L);
                            break;
                        case "ss":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the time");
            }
        }

        if (format.equals("dd/mm/yyyy hh:mm:ss")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "mm":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        case "dd":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yyyy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
            try {
                for (int i = 0; i < conT.length; i++) {
                    switch (conT[i].toLowerCase()) {
                        case "hh":
                            this.date.setTime(Integer.parseInt(valT[i]) * 3600L);
                            break;
                        case "mm":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]) * 60L);
                            break;
                        case "ss":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the time");
            }
        }

        if (format.equals("dd-mmm-yyyy hh:mm")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "mmm":
                            this.date.setMonth(CONSTANTS.monthsMapNames.get(val[i]));
                            break;
                        case "dd":
                            this.date.setDate(Integer.parseInt(val[i]));
                            break;
                        case "yyyy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
            try {
                for (int i = 0; i < conT.length; i++) {
                    switch (conT[i].toLowerCase()) {
                        case "hh":
                            this.date.setTime(Integer.parseInt(valT[i]) * 3600L);
                            break;
                        case "mm":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]) * 60L);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the time");
            }
        }

        if (format.equals("/m/yy hh:mm:ss")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "":
                            this.date.setDate(1);
                            break;
                        case "m":
                            this.date.setMonth(Integer.parseInt(val[i]));
                            break;
                        case "yy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
            try {
                for (int i = 0; i < conT.length; i++) {
                    switch (conT[i].toLowerCase()) {
                        case "hh":
                            this.date.setTime(Integer.parseInt(valT[i]) * 3600L);
                            break;
                        case "mm":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]) * 60L);
                            break;
                        case "ss":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the time");
            }
        }

        if (format.equals("yyyy mm:ss")) {
            try {
                for (int i = 0; i < con.length; i++) {
                    switch (con[i].toLowerCase()) {
                        case "":
                            this.date.setMonth(1);
                            this.date.setDate(1);
                            break;
                        case "yyyy":
                            this.date.setYear(Integer.parseInt(val[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the date");
            }
            try {
                for (int i = 0; i < conT.length; i++) {
                    switch (conT[i].toLowerCase()) {
                        case "mm":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]) * 60L);
                            break;
                        case "ss":
                            this.date.setTime(this.date.getTime() + Integer.parseInt(valT[i]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                throw new InvalidDateFormatException("Wrong format! Please check the time");
            }
        }
        dateFormatCheck();
    }

    public void dateFormatCheck() throws InvalidDateFormatException {

        if (this.date.getMonth() < 1 || this.date.getMonth() > 12) {
            throw new InvalidDateFormatException("Wrong month entered!");
        }
        if (this.date.getDate() > 0) {
            if (this.date.getDate() > CONSTANTS.monthsMap.get(this.date.getMonth())) {
                if (this.date.getMonth() == 2 && !isLeapYear(this.date.getYear())
                    && this.date.getDate() == 29) throw new InvalidDateFormatException("This is not a leap year!");
                if (!(this.date.getMonth() == 2 && isLeapYear(this.date.getYear())
                    && this.date.getDate() == 29))
                    throw new InvalidDateFormatException("Invalid date entered!");
            }
        } else {
            throw new InvalidDateFormatException("Invalid date entered!");
        }
        if (this.date.getYear() < 0) {
            throw new InvalidDateFormatException("Wrong year entered! Must be at least 0");
        }

        if (this.date.getTime() < 0 || this.date.getTime() >= 86400)
            throw new InvalidDateFormatException("Wrong time entered!");
    }

    public boolean after(Calendar calendar) throws NullPointerException {
        if (calendar == null) throw new NullPointerException("The date cannot be empty!");
        if (date.getYear() > calendar.date.getYear()) return true;
        else if ((date.getYear() == calendar.date.getYear()) &&
            (date.getMonth() > calendar.date.getMonth())) return true;
        else if ((date.getMonth() == calendar.date.getMonth()) &&
            (date.getDate() > calendar.date.getDate())) return true;
        else return (date.getDate() == calendar.date.getDate()) &&
                (date.getTime() > calendar.date.getTime());
    }

    public boolean before(Calendar calendar) throws NullPointerException {
        if (calendar == null) throw new NullPointerException("The date cannot be empty!");
        if (date.getYear() < calendar.date.getYear()) return true;
        else if ((date.getYear() == calendar.date.getYear()) &&
            (date.getMonth() < calendar.date.getMonth())) return true;
        else if ((date.getMonth() == calendar.date.getMonth()) &&
            (date.getDate() < calendar.date.getDate())) return true;
        else return (date.getDate() == calendar.date.getDate()) &&
                (date.getTime() < calendar.date.getTime());
    }

    public static void sortBigger(Calendar[] dates) {
        for (int i = dates.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dates[j] != null && dates[j + 1] != null) {
                    if (dates[j].after(dates[j + 1])) {
                        Calendar tmp = dates[j];
                        dates[j] = dates[j + 1];
                        dates[j + 1] = tmp;
                    }
                } else {
                    System.out.println("Nothing to compare!");
                }
            }
        }
    }

    public static void sortSmaller(Calendar[] dates) {
        for (int i = dates.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dates[j] != null && dates[j + 1] != null) {
                    if (dates[j].before(dates[j + 1])) {
                        Calendar tmp = dates[j];
                        dates[j] = dates[j + 1];
                        dates[j + 1] = tmp;
                    }
                } else {
                    System.out.println("Nothing to compare!");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "domain.Calendar{" +
            "date=" + date +
            '}';
    }
}
