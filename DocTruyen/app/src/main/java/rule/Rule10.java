package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule10 implements Rule {
    // 10) Chỉ có một số nguyên âm được phép đứng đằng sau "á" để tạo thành cặp nguyên âm. Hãy liệt kê: ái, áu, áo, áy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "iuoy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'á') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
