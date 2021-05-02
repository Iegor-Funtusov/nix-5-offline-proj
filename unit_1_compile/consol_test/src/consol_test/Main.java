package consol_test;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName(DnaGenerator.generateName());
        animal.setHeight(DnaGenerator.generateHeight());
        animal.setWeight(DnaGenerator.generateWeight());
        animal.setNumberPaws(DnaGenerator.generateQuantityPaws());
        animal.introduceYourself();
    }
}
