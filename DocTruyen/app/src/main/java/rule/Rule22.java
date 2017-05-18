package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule22 implements Rule {
    public static final Rule22 instance = new Rule22();
//
//    public Rule22() {
//        SpellCheck.rules.add(this);
//    }

    // 24B) Nguyên âm i được phép đi cùng "ó", "ố", "ỗ", "ọ", "ỏ", "ò", "á", "ấ", "ặ"
    // nhưng đó phải là từ "gió" , "giống", "giỗ", "giọng", "giỏ", "giò", "giá", "giấc", "giặc",
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        String temp = "óốỗọỏòáặấ";
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'i') {
                if (temp.contains(chars[i + 1] + "")) {
                    if (word.contains("giữ") || word.contains("gió") || word.contains("giống")
                            || word.contains("giỗ") || word.contains("giọng") || word.contains("giỏ")
                            || word.contains("giò") || word.contains("giá") || word.contains("giấ")
                            || word.contains("giặc")
                            )
                        return false;
                    return true;
                }
            }
        }
        return false;
    }
}
