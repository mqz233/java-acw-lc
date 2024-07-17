package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216_2 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void fnc(int k, int n, int sum, int index) {
        // 找到符合的size了
        if (path.size() == k) {
            if (sum == n)
            {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        int max = n - sum;
        if (max >= 9) max = 9;
        for (int i = index; i <= max; i++) {
            path.add(i);
            sum += i;
            // 和过大
            if (sum>n) break;
            fnc(k,n,sum,i+1);
            sum-=i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        // k=3,n=7 [1,2,4]
        fnc(k, n, 0, 1);
        return res;

    }
}
