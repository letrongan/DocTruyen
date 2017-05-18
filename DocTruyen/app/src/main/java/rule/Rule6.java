package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule6 implements Rule {
        // 6) Trong tiếng Việt, không phải nguyên âm nào cũng đứng trước t, c, p, ch được.
// Hãy liệt kê các nguyên âm được phép đứng trước chúng. => Chỉ có các từ có dấu sắc hoặc dấu nặng được phép
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "ạáặắậấẹéệếịíọóộốợớụúựứỵý";
        for (int i = 0; i < chars.length - 1; i++) {
            if (!temp.contains(chars[i] + "")) {
                if (chars[i + 1] == 't' && chars[i + 1] == 'c' && chars[i + 1] == 'p')
                    return true;
            }
        }
        return false;
    }
}
