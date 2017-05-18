package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule32 implements Rule {

    // 32) Nguyên âm "ễu" chỉ được phép đi trong từ "Tễu" và "phễu"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "iayêởế";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ũ') {
                if (SpellCheck.checkVowel(chars[i + 1])) {
                    if (!temp.contains(chars[i + 1]+""))
                        return true;
                }
            }
        }
        return false;
    }
}
