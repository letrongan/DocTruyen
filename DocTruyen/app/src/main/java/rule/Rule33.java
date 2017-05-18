package rule;

/**
 * Created by TieuHoan on 11/05/2017.
 */

public class Rule33 implements Rule {
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "jwzf";
        for (int i = 0; i < chars.length; i++) {
            if (temp.contains(chars[i] + ""))
                return true;
        }
        return false;
    }
}
