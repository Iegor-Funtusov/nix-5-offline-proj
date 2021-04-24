import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Dog> dogs = ImmutableSet.of(new Dog(), new Dog());
        for(Dog dog : dogs) {
            System.out.println(dog.speak());
        }
    }
}
