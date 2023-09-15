package carl.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    private HashMap<Integer, char[]> map = new HashMap<Integer, char[]>() {
        {
            put(2, new char[]{'a', 'b', 'c'});
            put(3, new char[]{'d', 'e', 'f'});
            put(4, new char[]{'g', 'h', 'i',});
            put(5, new char[]{'j', 'k', 'l'});
            put(6, new char[]{'m', 'n', 'o'});
            put(7, new char[]{'p', 'q', 'r', 's'});
            put(8, new char[]{'t', 'u', 'v'});
            put(9, new char[]{'w', 'x', 'y', 'z'});
        }
    };
    private StringBuilder tmp = new StringBuilder();
    private List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtracking(tmp, 0, digits);
        return res;

    }

    private void backtracking(StringBuilder tmp, int index, String digits) {
        if (tmp.length() == digits.length()) {
            res.add(new String(tmp));
            return;
        }

        // digits index下标对应的数字 这里要减去'0'
        Integer digit = (int) (digits.charAt(index) - '0');
        // 该数字对应字符数组
        char[] letters = map.get(digit);
        for (int i = 0; i < letters.length; i++) {
            tmp.append(letters[i]);
            backtracking(tmp, index + 1, digits);
            tmp.deleteCharAt(tmp.length() - 1);
        }


    }

}
