package carl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        //做尾部删除操作，用LinkedList
        LinkedList<Integer> ele = new LinkedList<>();
        backtracking(res, ele, k, 1, n);

        return res;

    }

    private void backtracking(List<List<Integer>> res, LinkedList<Integer> ele, int size, int start, int end) {
        // 终止条件
        if (ele.size() == size) {
            // 结果集里加入时候，使用需要初始化一个新的。
            res.add(new ArrayList<>(ele));
            return;
        }

        // 横向遍历 start-end
        // ***剪枝*** 剩余元素个数要满足size要求
        for (int i = start; i <= end - (size - ele.size()) + 1; i++) {
            ele.add(i);
            // 纵向 元素个数达到size
            backtracking(res, ele, size, i + 1, end);
            // 回溯 清除加入的元素
            ele.removeLast();
        }
    }

}
