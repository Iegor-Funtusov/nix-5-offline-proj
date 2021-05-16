public class Weapon extends BaseEntity {

    private String model;
    private Integer licenseNumber;

    public String getModel() {
        return model;
    }

    public Weapon setModel(String model) {
        this.model = model;
        return this;
    }


    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public Weapon setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id='" + getId() + '\'' +
                ", model='" + model + '\'' +
                ", license Number='" + licenseNumber + '\'' +
                '}';
    }
}
