
import org.apache.commons.lang3.*;
import org.apache.commons.text.*;
public class Poetry {
    public static void main(String[] args) {
        Title title = new Title();

        TheBody theBody = new TheBody();
        String body = theBody.theBody();
        String newTitle = title.title();
        String upp = StringUtils.upperCase(newTitle);
        System.out.println(upp);
        System.out.println(body);

    }
}

//