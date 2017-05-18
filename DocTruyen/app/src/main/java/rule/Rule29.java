package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule29 implements Rule {


    // 36) Nguyên âm "ơ", "ớ", "ờ", "ở", "ợ" thì chỉ có đằng sau là nguyên âm "i"
//36B) Nguyên âm "ỡ" nếu đi sau nó là "i" thì từ đó phải là "hỡi"
//            37) Nguyên âm "ô", "ố", "ồ", "ổ", "ộ", "ỗ" thì chỉ có đằng sau là nguyên âm "i"
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ơ ớ ờ ở ợ ô ố ồ ổ ộ ỗ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkVowel(chars[i + 1]) && temp.contains(chars[i] + "")) {
//                if (chars[i] == 'ợ' && word.equals("rượu")) {
//                    return false;
//                }

                if (chars[i + 1] != 'i' && chars[i + 1] != 'u')
                    return true;
            }
//
//            if (chars[i] == 'ỡ' && chars[i + 1] == 'i' && !word.equals("hỡi"))
//                return true;
//
//            if (chars[i] == 'ợ' && chars[i + 1] == 'i' && !word.equals("rượu"))
//                return true;
        }
        return false;
    }
}
