package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule9B implements Rule {

    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ấ') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
