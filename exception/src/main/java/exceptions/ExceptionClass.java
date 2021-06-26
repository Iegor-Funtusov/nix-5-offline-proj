package exceptions;

public class ExceptionClass extends Exception{
    private String message;

    public ExceptionClass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return /*"Exception{" +
            "message='" + message + '\'' +
            "} " + */super.toString();
    }
}
