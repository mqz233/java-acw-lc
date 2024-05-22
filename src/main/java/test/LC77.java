package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

    // res
    public List<List<Integer>> res = new ArrayList<>();

    // path
    public LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        LC77 lc77 = new LC77();
        lc77.combine(4, 2);
    }

    void fnc(int n, int k, int cur) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝 这层的i最多到哪,再往后，不够K个了
        for (int i = cur; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            fnc(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        // k =2 n=3  1,2 1,3 2,3
        fnc(n, k, 1);
        return res;

    }
}
