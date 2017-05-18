package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule28 implements Rule {

    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String follow = "aie";
        String it = "o ó ò ỏ ọ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (it.contains(chars[i] + "")) {
                if (SpellCheck.checkVowel(chars[i + 1]) && !follow.contains(chars[i + 1] + "")) {
                    if (word.equals("xoong") || word.equals("boong"))
                        return false;
                    return true;
                }
            }
        }
        return false;
    }
}
