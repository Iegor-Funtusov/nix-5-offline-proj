package level1.knight_turn;

public class Knight {
    private boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        if (!isEmpty) {
            return !isEmpty
            ? "K"
            : "" ;
        } else {
            return isEmpty
                    ? "."
                    : "";
        }
    }
}
