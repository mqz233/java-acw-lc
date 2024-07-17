package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77_2 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    // 回溯
    public void fnc(int index, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            fnc(i  + 1, n, k);
            path.removeLast();
        }
    }

    // n=4 k=2 1,2 1,3 1,4 2,3 2,4 3,4
    public List<List<Integer>> combine(int n, int k) {

        fnc(1, n, k);
        return res;

    }
}
