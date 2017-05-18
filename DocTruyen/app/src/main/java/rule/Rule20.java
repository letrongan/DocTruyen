package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule20 implements Rule {
    public static final Rule20 instance = new Rule20();
//
//    public Rule20() {
//        SpellCheck.rules.add(this);
//    }

    // 20) Chỉ có một số nguyên âm được phép đứng đằng sau "ầ" để tạo thành cặp nguyên âm. Hãy liệt kê: ầu, ầy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ầ') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
