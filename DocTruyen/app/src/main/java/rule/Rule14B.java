package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule14B implements Rule {

    // 14B) Chỉ có một số nguyên âm được phép đứng đằng sau "à" để tạo thành cặp nguyên âm. Hãy liệt kê: ài, àu, ào, ày.
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "iuoy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'à') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
