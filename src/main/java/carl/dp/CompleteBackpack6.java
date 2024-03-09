package carl.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.dp
 * @Project：java-acw-lc
 * @name：CompleteBackpack2
 * @Date：2024/3/8 14:25
 * @Filename：CompleteBackpack2
 * @Desc： 单词拆分 https://leetcode.cn/problems/word-break/description/ 完全背包,排列
 */
public class CompleteBackpack6 {

    public static void main(String[] args) {
        CompleteBackpack6 completeBackpack3 = new CompleteBackpack6();
        boolean result = completeBackpack3.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("aaa", "apple", "pen")));
        System.out.println(result);
    }


    // 字符串拼接后为s,装满背包
    // 以前是数字往背包里塞,求组合种类或排列种类
    // 现在是拿着一部分字符串上wordDict里找,看能不能找到
    public boolean wordBreak(String s, List<String> wordDict) {

        // dp[j]含义 长度为j的字符串是否在s中出现
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化dp[0]为true,dp[j]为false
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
        }
        // 遍历顺序 完全背包+排列
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                // 截取i-j之间的字符串,在wordDict中查找
                String tmp = s.substring(i, j);
                // 如果wordDict中存在该字符串,且dp[i]为true,也就是0-i之间也能在wordSet中找到
                if (dp[i] && wordDict.contains(tmp)) {
                    // 更新dp[j]状态
//                    System.out.print(j);
//                    System.out.print(' ');
//                    System.out.print(i);
//                    System.out.print(' ');
                    dp[j] = true;
                    break;
                }
            }
//            System.out.println(" round ");

        }

        return dp[s.length()];


    }
}
