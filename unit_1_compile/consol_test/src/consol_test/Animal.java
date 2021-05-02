package consol_test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Animal {

    private String name;
    private int numberPaws;
    private int weight;
    private int height;

    public void introduceYourself()
    {
        System.out.println("   Мне дали милозвучное имя: " + name);
        //System.out.println(" My name is: " + name);
    }

}
