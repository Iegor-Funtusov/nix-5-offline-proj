package ua.practice.unit7.handlers;

public class DateTimeFormatter {

    private DataTypes dataType = DataTypes.TYPE1;
    private final StringBuilder sb = new StringBuilder();

    public void printUsingFormat(DateTime dateTime){
        switch (dataType)
        {
            case TYPE1: // dd/mm/yy
                sb.append(dateTime.getDate().getDay()).append("/");
                sb.append(dateTime.getDate().getMonth().getMonthNumber()).append("/");
                sb.append(dateTime.getDate().getYear().getYear());
                break;
            case TYPE2: // m/d/yyyy
                sb.append(dateTime.getDate().getMonth().getMonthNumber()).append("/");
                sb.append(dateTime.getDate().getDay()).append("/");
                sb.append(dateTime.getDate().getYear().getYear());
                break;
            case TYPE3: // mmm-d-yy
                sb.append(dateTime.getDate().getMonth().name()).append("-");
                sb.append(dateTime.getDate().getDay()).append("-");
                sb.append(dateTime.getDate().getYear().getYear());
                break;
            case TYPE4: // dd-mmm-yyyy 00:00
                sb.append(dateTime.getDate().getDay()).append("-");
                sb.append(dateTime.getDate().getMonth().name()).append("-");
                sb.append(dateTime.getDate().getYear().getYear()).append(" ");
                sb.append(dateTime.getTimeOfDay().getHours()).append(":");
                sb.append(dateTime.getTimeOfDay().getMinutes()).append(":");
                sb.append(dateTime.getTimeOfDay().getSeconds());
                break;
            default:
                System.out.println("Something went wrong!");
        }
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public DataTypes getDataType() {
        return dataType;
    }

    public void setDataType(DataTypes dataType) {
        this.dataType = dataType;
    }
}
