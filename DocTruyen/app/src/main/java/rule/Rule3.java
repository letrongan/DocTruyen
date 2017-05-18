package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule3 implements Rule {

    // 3) Nếu một từ có phụ âm c đứng đầu thì phụ âm sau nó (nếu có) phải là H.
    @Override
    public boolean check(String word) {
        if (word != null && word.length() > 0) {
            if (word.charAt(0) == 'c') {
                if (word.length() >= 2) {
                    if (SpellCheck.checkConsonant(word.charAt(1))
                            && !(word.charAt(1) == 'h'))
                        return true;
                }
            }
        }

        return false;
    }
}
