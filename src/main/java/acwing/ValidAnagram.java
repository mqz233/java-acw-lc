package acwing;

// test
// https://leetcode.cn/problems/valid-anagram/
// 有效的字母异位词 (哈希表)
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        int N = 26;
        int[] resultSet = new int[N];
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            resultSet[u]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int u = t.charAt(i) - 'a';
            resultSet[u]--;
        }
        for (int i = 0; i < N; i++) {
            if (resultSet[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
