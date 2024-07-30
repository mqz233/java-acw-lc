package july;
import java.util.*;

/**
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class LC46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    public void fnc(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            fnc(nums);
            path.removeLast();
            set.remove(nums[i]);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        fnc(nums);
        return res;
    }
}
