package dates;

import operations.Comparing;
import operations.Difference;
import operations.Subtracting;
import obj.Date;
import operations.Adding;

import java.time.DateTimeException;
import java.util.List;

public class CalendarService {

    private final Comparing compare = new Comparing();
    private final Subtracting subtract = new Subtracting();
    private final Adding add = new Adding();
    private final Difference diff = new Difference();

    public List<Date> compare(List<Date> list, String order) {
        if ("1".equals(order)) {
            return compare.compareAscending(list);
        } else if ("2".equals(order)) {
            return compare.compareDescending(list);
        }
        return list;
    }

    public Date subtract(Date date, int value, String units) {
        switch (units) {
            case "secs":
                return subtract.subtractSecs(date, value);
            case "mins":
                return subtract.subtractMins(date, value);
            case "hours":
                return subtract.subtractHours(date, value);
            case "days":
                return subtract.subtractDays(date, value);
            case "months":
                return subtract.subtractMonths(date, value);
            case "years":
                return subtract.subtractYears(date, value);
        }
        return date;
    }

    public Date add(Date date, int value, String units) {
        switch (units) {
            case "secs":
                return add.addSecs(date, value);
            case "mins":
                return add.addMins(date, value);
            case "hours":
                return add.addHours(date, value);
            case "days":
                return add.addDays(date, value);
            case "months":
                return add.addMonths(date, value);
            case "years":
                return add.addYears(date, value);
        }
        return date;
    }

    public double findDiff(Date from, Date to, String units) throws DateTimeException {
        switch (units) {
            case "secs":
                return diff.diffInSecs(from, to);
            case "mins":
                return diff.diffInMins(from, to);
            case "hours":
                return diff.diffInHours(from, to);
            case "days":
                return diff.diffInDays(from, to);
            case "months":
                return diff.diffInMonths(from, to);
            case "years":
                return diff.diffInYears(from, to);
        }
        return -1;
    }

}
