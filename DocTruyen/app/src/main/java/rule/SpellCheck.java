package rule;

import java.util.ArrayList;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class SpellCheck {
    public static final ArrayList<Rule> rules = new ArrayList<>();
    public static final String vowel = "aăâeêioôơuưy";
    public static final String consonant = "bcdđghklmnpqrstvx";
    public static final String pattern = "[/:*?[],.'~!@#$%^&*()+-_={}<>]\\";

    static  {
        rules.add(new Rule1());
        rules.add(new Rule3());
        rules.add(new Rule4());
        rules.add(new Rule5());
        rules.add(new Rule6());
        rules.add(new Rule7());
        rules.add(new Rule8());
        rules.add(new Rule9());
        rules.add(new Rule9B());
        rules.add(new Rule10());
        rules.add(new Rule11());
        rules.add(new Rule12());
        rules.add(new Rule13());
        rules.add(new Rule14());
        rules.add(new Rule14B());
        rules.add(new Rule15());
        rules.add(new Rule16());
        rules.add(new Rule17());
        rules.add(new Rule18());
        rules.add(new Rule19());
        rules.add(new Rule20());
        rules.add(new Rule21());
        rules.add(new Rule22());
        rules.add(new Rule23());
        rules.add(new Rule24());
        rules.add(new Rule25());
        rules.add(new Rule26());
        rules.add(new Rule27());
        rules.add(new Rule29());
        rules.add(new Rule30());
        rules.add(new Rule31());
        rules.add(new Rule32());
        rules.add(new Rule33());
    }

    public static boolean check(String word) {

        char[] temp = word.toCharArray();
        word = "";
        for (int i = 0; i < temp.length; i++) {
            if (!pattern.contains(temp[i] + "")) {
                word += String.valueOf(temp[i]);
            }
        }
            word = word.toLowerCase();
        for (Rule rule : rules) {
            if (word != null && word.length() > 0) {
                if (rule.check(word)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean checkConsonant(char x) {
        if (consonant.contains(x + ""))
            return true;
        return false;
    }

    public static boolean checkVowel(char x) {
        if (vowel.contains(x + ""))
            return true;
        return false;
    }
}
