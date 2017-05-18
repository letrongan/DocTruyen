package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule21 implements Rule {
    public static final Rule21 instance = new Rule21();
//
//    public Rule21() {
//        SpellCheck.rules.add(this);
//    }

    // 21) KHÔNG nguyên âm được phép đứng đằng sau "ă" để tạo thành cặp nguyên âm.
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ăắằặẵẳ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkVowel(chars[i + 1]) &&  temp.contains(chars[i] + "")) {
                if (SpellCheck.checkVowel(chars[i + 1]))
                    return true;
            }
        }
        return false;
    }
}
