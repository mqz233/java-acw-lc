package test;
import java.util.*;

public class LC78 {

    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public void fnc(int[] nums, int index){

        // 进到fnc里的都算子集，空的也算
        res.add(new ArrayList<>(path));

        // 终止条件 index = nums.length
        if (index == nums.length){
            return;
        }

        // 从index开始选取元素
        // 刚进来 []
        // 第一层选 1,2,3
        // 第二层 1,2 1,3 2,3
        //第三层 1,2,3
        for (int i=index;i<nums.length;i++){
            path.add(nums[i]);
            fnc(nums,i+1);
            path.removeLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        fnc(nums,0);
        return res;
    }
}
