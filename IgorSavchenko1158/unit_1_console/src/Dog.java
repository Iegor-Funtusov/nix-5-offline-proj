import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;


public class Dog implements ISpeak {
    @Override
    public String speak() {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append("woof").append(" ");
        } while (RandomUtils.nextBoolean());

        return StringUtils.capitalize(sb.toString().trim());
    }
}
