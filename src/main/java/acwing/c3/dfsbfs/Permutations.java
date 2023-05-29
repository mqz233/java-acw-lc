package acwing.c3.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mqz23
 * 全排列 深度优先搜索 https://leetcode.cn/problems/permutations/submissions/
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3, 4}));
    }

    public List<List<Integer>> permute(int[] nums) {

        // 用来保存每一种情况
        List<Integer> output = new ArrayList<>();
        // 转换成ArrayList （可有可无）
        for (int num : nums) {
            output.add(num);
        }
        // 用来保存最终结果
        List<List<Integer>> result = new ArrayList<>();

        // 递归
        traceback(output.size(), 0, output, result);

        return result;


    }

    // 递归方法 list长度 positon当前位置 ouput保存每一种 result保存最终结果
    public void traceback(int length, int position, List<Integer> output, List<List<Integer>> result) {

        // 当前位置等于长度，添加到result，返回
        // XXX result.add(output); 保存的是引用，这里需要重新生成
        if (position == length) {
            result.add(new ArrayList<>(output));
            return;
        }

        // 从当前位置开始（当前位置之前的已经确定，不会再进行选择，避开了重复选择），遍历所有可能的情况
        for (int i = position; i < length; i++) {
            // 技巧：使用交换的方法，而不是重新生成数组（节省空间，不需要bool数组保存状态）
            Collections.swap(output, position, i);
            // 递归遍历下一个位置
            traceback(length, position+1, output, result);
            // 进行下一次交换之前，恢复到初始状态
            Collections.swap(output, position, i);
        }

    }

}
