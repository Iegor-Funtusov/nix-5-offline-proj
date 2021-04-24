package ua.practice.maven;

public class Subscriber {
    private String lastName;
    private String telephone;

    public Subscriber(String lastName, String telephone) {
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        return telephone.equals(that.telephone);
    }

    @Override
    public int hashCode() {
        return telephone.hashCode();
    }

    @Override
    public String toString() {
        return "Subscriber with " +
                "lastName='" + lastName + '\'' +
                " and telephone='" + telephone + '\'';
    }

}
