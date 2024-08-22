package _24july;
import java.util.*;

/**
 * @description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 */
public class LC78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void fnc(int[] nums ,int index){
        res.add(new ArrayList<>(path));

        for(int i=index;i<nums.length;i++){
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
