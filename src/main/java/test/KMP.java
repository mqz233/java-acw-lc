package test;

public class KMP {
    // 原理 pattern向前移动，一趟遍历，str可以回溯回溯的位置由next数组决定
    // 匹配成功，那么i,j++
    // 匹配失败，j = next[j-1]
    // next[j-1]=0,那么i++

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.kmp("ABCDABCDABDE", "ABCDABD"));
    }

    public int kmp(String str, String pattern) {
        int[] next = buildNext(pattern);
        int length = str.length();
        int i = 0;
        int j = 0;
        while (i < length) {
            if (pattern.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
            if (j == pattern.length()) {
                return i - j;
            }
        }

        return -1;
    }

    private int[] buildNext(String pattern) {
        // 只遍历一遍pattern
        // 长度为1的子串，长度为2的字串 。。。
        int length = pattern.length();
        int[] next = new int[length];
        next[0] = 0;
        // i用来记录当前pattern的下标
        int i = 1;
        // j用来记录最长前后缀
        int j = 0;
        while (i < length) {
            // 匹配成功
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // 长度+1
                j = j + 1;
                next[i] = j;
                i = i + 1;
            } else if (j == 0) {
                next[i] = 0;
                i++;
            } else {
                j = next[j - 1];
            }
        }

        return next;
    }

}
