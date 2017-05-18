package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule25 implements Rule {

    // 30) Các nguyên âm được phép sau "e", "é", "è", "ẻ", "ẹ", "ẽ" thì chỉ có: "o"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "e é ẹ ẻ è é";
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkVowel(chars[i + 1]) && temp.contains(chars[i] + "")) {
                if (chars[i + 1] != 'o')
                    return true;
            }
        }
        return false;
    }
}
