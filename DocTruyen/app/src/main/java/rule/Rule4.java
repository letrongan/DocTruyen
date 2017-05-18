package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule4 implements Rule {
    // 4) Luật 8 có thể tổng quát như sau: Nếu một từ có 2 phụ âm cạnh nhau thì các phụ âm đó phải là: tr, th, ph, gh, kh, ch, nh, ng,
    @Override
    public boolean check(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (SpellCheck.checkConsonant(chars[i])
                    && SpellCheck.checkConsonant(chars[i + 1])) {
                String temp = "" + chars[i];
                temp += "" + chars[i + 1];
                if (!temp.equals("tr") && !temp.equals("th") && !temp.equals("ph")
                        && !temp.equals("gh") && !temp.equals("kh") && !temp.equals("ch")
                        && !temp.equals("nh") && !temp.equals("ng")) {
                    return true;
                }
            }
        }
        return false;
    }
}
