package constants;

public enum FileConstants {
    DATES("src/main/resources/examples/dates/input.txt"),
    NAMES("src/main/resources/examples/names/input.txt"),
    CITY_INPUT("src/main/resources/examples/graphs/input.txt"),
    CITY_OUTPUT("src/main/resources/examples/graphs/output.txt");

    private final String path;

    FileConstants(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
