package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule18 implements Rule {
    public static final Rule18 instance = new Rule18();
//
//    public Rule18() {
//        SpellCheck.rules.add(this);
//    }


    // 18) Chỉ có một số nguyên âm được phép đứng đằng sau "ẫ" để tạo thành cặp nguyên âm. Hãy liệt kê: ẫu, ẫy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ẫ') {
                if (SpellCheck.checkVowel(chars[i + 1]) && !temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
