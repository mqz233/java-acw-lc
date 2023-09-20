package carl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 什么时候加入解集合判断失误，当切割到末尾的时候，说明成功找到切割回文串的办法。
public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> tmp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, s.length());
        return res;
    }

    void backtracking(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i < endIndex; i++) {
            if (!isPalindrome(s.substring(startIndex, i + 1))) {
                continue;
            }
            tmp.add(s.substring(startIndex, i + 1));
            backtracking(s, i + 1, endIndex);
            tmp.removeLast();
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
