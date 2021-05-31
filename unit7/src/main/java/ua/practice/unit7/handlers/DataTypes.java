package ua.practice.unit7.handlers;

public enum DataTypes {
    TYPE1("dd/mm/yy"),
    TYPE2("m/d/yyyy"),
    TYPE3("mmm-d-yy"),
    TYPE4("dd-mmm-yyyy 00:00");

    private final String type;

    private DataTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
