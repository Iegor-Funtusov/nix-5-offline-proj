package operations;

import java.util.List;
import java.util.Collections;

public class Comparing {

    public <T extends Comparable<T>> List<T> compareAscending(List<T> list) {
        Collections.sort(list);
        return list;
    }

    public <T extends Comparable<T>> List<T> compareDescending(List<T> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}
