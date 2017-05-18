package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule15 implements Rule {
    public static final Rule15 instance = new Rule15();
//
//    public Rule15() {
//        SpellCheck.rules.add(this);
//    }

    // 15) Chỉ có một số nguyên âm được phép đứng đằng sau "â" để tạo thành cặp nguyên âm. Hãy liệt kê: âu, ây
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'â') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
