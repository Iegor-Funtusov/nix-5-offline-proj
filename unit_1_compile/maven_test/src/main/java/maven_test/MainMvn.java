package maven_test;

public class MainMvn {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName(DnaGenerator.generateName());
        animal.setHeight(DnaGenerator.generateHeight());
        animal.setWeight(DnaGenerator.generateWeight());
        animal.setNumberPaws(DnaGenerator.generateQuantityPaws());
        animal.introduceYourself();
    }
}
