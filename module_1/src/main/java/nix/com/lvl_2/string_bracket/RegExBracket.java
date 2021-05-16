package nix.com.lvl_2.string_bracket;

public class RegExBracket {
    public boolean checkString(String str) {
        if (str.isBlank()) {
            return true;
        }

        if (str.matches("(?=(?:\\(.*\\)|\\[.*\\]|\\{.*\\}|[.])$)[\\[{(][0-9a-f]*[\\]})]")) {
            return true;
        }
        return false;
    }
}
