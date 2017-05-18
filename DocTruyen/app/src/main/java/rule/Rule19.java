package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule19 implements Rule {
    public static final Rule19 instance = new Rule19();
//
//    public Rule19() {
//        SpellCheck.rules.add(this);
//    }

    // 19) Chỉ có một số nguyên âm được phép đứng đằng sau "ậ" để tạo thành cặp nguyên âm. Hãy liệt kê: ậu, ậy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ậ') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
