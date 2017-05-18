package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule27 implements Rule {

    // 32) Nguyên âm "ễu" chỉ được phép đi trong từ "Tễu" và "phễu"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (SpellCheck.checkConsonant(chars[i - 1]) && chars[i] == 'ễ' && chars[i + 1] == 'u' && !word.equals("tễu") && !word.equals("phễu"))
                return true;

//            if (chars[i] == 'ể' && SpellCheck.checkVowel(chars[i + 1]))
//                return true;
        }
        return false;
    }
}
