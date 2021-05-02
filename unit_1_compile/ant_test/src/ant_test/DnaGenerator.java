package ant_test;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class DnaGenerator {

    public static String generateName(){

        Random random = new Random();
        int quantitySymbols = random.nextInt(16)+4;
        return RandomStringUtils.random(quantitySymbols);

    }

    public static int generateQuantityPaws(){

        Random random = new Random();
        return random.nextInt(40);

    }

    public static int generateWeight(){

        Random random = new Random();
        return random.nextInt(5000);

    }

    public static int generateHeight(){

        Random random = new Random();
        return random.nextInt(10);

    }

}
