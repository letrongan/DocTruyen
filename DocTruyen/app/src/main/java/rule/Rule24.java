package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule24 implements Rule {

//    25) Các nguyên âm được phép sau nguyên âm "ì": ìu, ìa,
//            26) Các nguyên âm được phép sau nguyên âm "ỉ": ỉu, mỉa,
//            27) Các nguyên âm được phép sau nguyên âm "ị": ịu, ịa,
//            28) Các nguyên âm được phép sau nguyên âm "ĩ": ĩu, ĩa,
//            29) Các nguyên âm được phép sau nguyên âm "í": íu, ía,
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String follow = "ua";
        String it = "ìỉịĩí";
        for (int i = 0; i < chars.length - 1; i++) {
            if (it.contains(chars[i] + "")) {
                if (SpellCheck.checkVowel(chars[i + 1]) && !follow.contains(chars[i + 1] + ""))
                    return true;
            }
        }
        return false;
    }
}
