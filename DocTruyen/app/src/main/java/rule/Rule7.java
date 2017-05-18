package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule7 implements Rule {
    // 7) Trong tiếng Việt có một số phụ âm không được đứng cuối từ: q v b d l k s x r đ
    @Override
    public boolean check(String word) {
        String temp = "qvbdlksxrđ";
        if (word != null && word.length() > 0) {

            if (temp.contains(word.charAt(word.length() - 1) + ""))
                return true;
        }
        return false;
    }
}
