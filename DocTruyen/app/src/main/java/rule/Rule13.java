package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule13 implements Rule {

    // 13) Chỉ có một số nguyên âm được phép đứng đằng sau "ả" để tạo thành cặp nguyên âm. Hãy liệt kê: ải, ảo, ảy.

    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ioy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ả') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
