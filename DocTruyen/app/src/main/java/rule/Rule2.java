package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule2 implements Rule {

    //2) Một từ tiếng Việt có tối đa 5 phụ âm: nghiêng
    @Override
    public boolean check(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (SpellCheck.checkConsonant(word.charAt(i)))
                count++;
        }
        if (count == 5 && !word.equals("nghiêng"))
            return true;
        return false;
    }
}
