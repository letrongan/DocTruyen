package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule14 implements Rule {

    // 14) Nếu có "ảu" thì từ này bắt buộc phải nằm trong từ "nhảu"

    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'ả' && chars[i + 1] == 'u') {
                if (!word.equals("nhảu"))
                    return true;
            }
        }
        return false;
    }
}
