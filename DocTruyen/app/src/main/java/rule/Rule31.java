package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule31 implements Rule {

    public static final Rule31 instance = new Rule31();
//
//    public Rule31() {
//        SpellCheck.rules.add(this);
//    }

    // 31) Các nguyên âm được phép sau "ê", "ế", "ề", "ệ", thì chỉ có: "u"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String follow = "iay";
        String it = "ú ù ủ ụ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkVowel(chars[i + 1]) && it.contains(chars[i] + ""))
                if (!follow.contains(chars[i + 1] + ""))
                    return true;
        }
        return false;
    }
}
