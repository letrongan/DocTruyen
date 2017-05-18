package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule16 implements Rule{
    public static final Rule16 instance = new Rule16();
//
//    public Rule16() {
//        SpellCheck.rules.add(this);
//    }


    // 16) Chỉ có một số nguyên âm được phép đứng đằng sau "ấ" để tạo thành cặp nguyên âm. Hãy liệt kê: ấu, ấy
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "uy";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ấ') {
                if (SpellCheck.checkVowel(chars[i + 1]) &&!temp.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
