import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Book {
    private String id;
    private String title;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Author[] authors;

}
