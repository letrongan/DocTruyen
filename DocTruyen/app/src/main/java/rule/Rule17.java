package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule17 implements Rule {
    public static final Rule17 instance = new Rule17();
//
//    public Rule17() {
//        SpellCheck.rules.add(this);
//    }

    // 17) Chỉ có một số nguyên âm được phép đứng đằng sau "ẩ" để tạo thành cặp nguyên âm. Hãy liệt kê: ẩu, ẩy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ẩ') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
