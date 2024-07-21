package july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class LC216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    void fnc(int l, int r, int k, int n, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = l; i <= r - (k - path.size()) + 1; i++) {
            if (sum + i > n) break;
            path.add(i);
            sum += i;
            fnc(i + 1, r, k, n, sum);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        fnc(1, 9, k, n, 0);
        return res;
    }
}
