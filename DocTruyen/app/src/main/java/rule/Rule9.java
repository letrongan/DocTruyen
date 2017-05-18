package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule9 implements Rule {
    // 9) Có những phụ âm đứng cuối nhưng trước nó không được phép chứa phụ âm khác: n m t p c
    @Override
    public boolean check(String word) {
        String temp = "nmtpc";
        if (temp.contains(word.charAt(word.length() - 1) + "")
                && SpellCheck.checkConsonant(word.charAt(word.length() - 2))) {
            return true;
        }
        return false;
    }
}
