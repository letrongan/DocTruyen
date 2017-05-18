package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule26 implements Rule {

    // 31) Các nguyên âm được phép sau "ê", "ế", "ề", "ệ", thì chỉ có: "u"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ê ế ề ệ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (temp.contains(chars[i] + "")) {
                if (SpellCheck.checkVowel(chars[i + 1]) && chars[i + 1] != 'u')
                    return true;
            }
        }
        return false;
    }
}
