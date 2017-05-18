package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule5 implements Rule {
    // 5) Nếu một từ có 3 phụ âm cạnh nhau => đó phải là ngh

    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            if (SpellCheck.checkConsonant(chars[i])
                    && SpellCheck.checkConsonant(chars[i + 1])
                    && SpellCheck.checkConsonant(chars[i + 2])) {
                String temp = String.valueOf(chars[i]) + String.valueOf(chars[i + 1]) + String.valueOf(chars[i + 2]);
                if (!temp.equals("ngh"))
                    return true;
            }
        }
        return false;
    }
}
