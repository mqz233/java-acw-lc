package carl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backtracking(k, n, 0);
        return res;


    }

    void backtracking(int size, int sum, int cur) {

        //tmp内元素求和
        int tmpSum = 0;
        for (Integer i : tmp) {
            tmpSum += i;
        }

        // 剪枝：总和过大，剪掉
        if (tmpSum > sum) {
            return;
        }

        // 数量够了，要么总和对上加入解的集合，要么直接return
        if (tmp.size() == size) {
            if (tmpSum == sum) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }


        // 这里，剪掉数量size不够的
        for (int j = cur + 1; j < 10 - (size - tmp.size()) + 1; j++) {
            tmp.add(j);
            backtracking(size, sum, j);
            tmp.removeLast();
        }
    }

}

