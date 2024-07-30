package july;
import java.util.*;

/**
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    void fnc(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        boolean[] set = new boolean[21];
        for(int i=0; i<nums.length; i++){
            if(used[i]||set[nums[i]+10]) continue;
            path.add(nums[i]);
            // 多层之间，用过的数不能再用了（和全排列1一样）
            used[i] = true;
            // 一层内，用过的数只能用一次
            set[nums[i]+10] = true;
            fnc(nums);
            path.removeLast();
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        fnc(nums);
        return res;
    }
}
