package test;

import java.util.*;

/**
 * @Author：Yan Zhaoyang
 * @Package：test
 * @Project：java-acw-lc
 * @name：LC131_2
 * @Date：2024/6/28 21:50
 * @Filename：LC131_2
 * @Desc：
 */
public class LC131_2 {

    // 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
    //回文串
    // 。返回 s 所有可能的分割方案。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "aab"
    //输出：[["a","a","b"],["aa","b"]]
    //示例 2：
    //
    //输入：s = "a"
    //输出：[["a"]]
    //
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public void fnc(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        };

        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index, i + 1);
            if(check(tmp)){
                path.add(tmp);
                fnc(s,i+1);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        fnc(s,0);
        return res;
    }
}
