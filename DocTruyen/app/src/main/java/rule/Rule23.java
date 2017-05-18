package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule23 implements Rule {
    public static final Rule23 instance = new Rule23();

//    public Rule23() {
//        SpellCheck.rules.add(this);
//    }

    // 23) Các nguyên âm được phép sau nguyên âm "ấ": u, y

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
