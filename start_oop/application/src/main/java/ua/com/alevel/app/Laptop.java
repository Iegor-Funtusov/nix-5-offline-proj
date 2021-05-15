package ua.com.alevel.app;
import ua.com.alevel.lib.BaseEntity;

public class Laptop extends BaseEntity{
    private int laptopMemory;

    public int getLaptopMemory() {
        return laptopMemory;
    }

    public void setLaptopMemory(int laptopMemory) {
        if (laptopMemory > 0)
            this.laptopMemory = laptopMemory;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + super.getId() +
                ", laptopMemory=" + laptopMemory + " gigabytes" +
                '}';
    }
}
