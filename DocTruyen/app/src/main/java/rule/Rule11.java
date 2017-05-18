package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule11 implements Rule {
    // 11) Chỉ có một số nguyên âm được phép đứng đằng sau "ã" để tạo thành cặp nguyên âm. Hãy liệt kê: ãi, ão, ãy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ioy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ã') {
                if (SpellCheck.checkVowel(chars[i + 1]) &&!temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
