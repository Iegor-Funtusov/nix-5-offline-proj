import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Author {
    private String id;
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Book[] books;

}
