package rule;

/**
 * Created by KhoaBeo on 4/7/2017.
 */
public class Rule8 implements Rule {
    // 8) Có một số phụ âm được phép đứng cuối nhưng nó phải đi kèm với một phụ âm khác. Hãy xác định các cặp này: nh, ch, ng,
    @Override
    public boolean check(String word) {
        if (word.charAt(word.length() - 1) == 'h') {
            if (!(word.charAt(word.length() - 2) == 'c' || word.charAt(word.length() - 2) == 'n'))
                return true;
        }

        if (word.charAt(word.length() -1) == 'g') {
            if (!(word.charAt(word.length() -2) == 'n'))
                return true;
        }
        return false;
    }
}
