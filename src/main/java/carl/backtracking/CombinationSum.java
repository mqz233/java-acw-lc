package carl.backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
* */
public class CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tmp = new LinkedList<>();

    public static void main(String[] args) {
        List<List<Integer>> res = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 2) {
            return new ArrayList<>();
        }

        backtracking(0, candidates, target, 0);

        return res;
    }

    // index 指定选取的起始位置
    private void backtracking(int sum, int[] candidates, int target, int index) {

        // 起始位置超过边界
        if (index == candidates.length) {
            return;
        }

        // 成功等于target，加入并返回
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        // 大于target直接返回
        if (sum > target) {
            return;
        }

        // 不选当前元素，直接进入下一轮
        backtracking(sum, candidates, target, index + 1);

        // 选当前元素
        tmp.add(candidates[index]);
        sum += candidates[index];
        // 下一轮还可以继续选当前元素
        backtracking(sum, candidates, target, index);
        tmp.removeLast();

    }

}
