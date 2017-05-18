package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule30 implements Rule {

    // 30) Các nguyên âm được phép sau "e", "é", "è", "ẻ", "ẹ", "ẽ" thì chỉ có: "o"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "iaăâyeêởếô";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'u') {
                if ((SpellCheck.checkVowel(chars[i + 1])) && (word.equals("quý") || word.equals("quà")
                        || word.equals("que") || word.equals("quơ") || word.equals("huơ")
                        || word.equals("quá") || word.equals("quả") || word.equals("quạ")))
                    return false;
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
