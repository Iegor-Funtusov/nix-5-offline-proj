package ua.davidenko.formatter;

import ua.davidenko.date.Date;

public interface Formatter {

    String format(Date date);

    Date parse(String string);
}
