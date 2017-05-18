package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule1 implements Rule {

    //1) Các nguyên âm trong từ phải đứng cạnh nhau,
    // không có phụ âm chen vào giữa
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (SpellCheck.checkConsonant(chars[i])
                    && SpellCheck.checkVowel(chars[i - 1])
                    && SpellCheck.checkVowel(chars[i + 1])
                    )
                return true;
        }
        return false;
    }
}
