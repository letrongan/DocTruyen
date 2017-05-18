package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule12 implements Rule {

    // 12) Chỉ có một số nguyên âm được phép đứng đằng sau "ạ" để tạo thành cặp nguyên âm. Hãy liệt kê: ại, ạo, ạy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ioy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkVowel(chars[i + 1]) &&chars[i] == 'ạ') {
                if (!temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
