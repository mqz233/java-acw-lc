package carl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 组合总和2 候选集合有重复元素，且不可重复选用。
// 先排序，方便去重。
// 如果不排序，不好确定是横向遍历遇到的相同元素，还是纵向遍历遇到的相同元素。
public class CombinationSum2 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tmp = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {

        // 找到一种解法
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            // 和太大，直接跳过循环
            if (sum + candidates[i] > target) {
                break;
            }

            // 判断是横向出现的重复，还是纵向出现的重复，used[i-1]的值为false，说明是在同一层（横向）遇到的
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            sum += candidates[i];
            tmp.add(candidates[i]);
            used[i] = true;
            // 不能使用重复的元素,纵向直接从i+1开始
            backtracking(candidates, target, i + 1, sum);
            used[i] = false;
            tmp.removeLast();
            sum -= candidates[i];

        }
    }

}
