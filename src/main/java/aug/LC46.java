package aug;
import java.util.*;

public class LC46 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public void fnc(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            fnc(nums);
            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        fnc(nums);
        return res;
        // 1 2 3
        // 1 2 3 // 1 3 2
        // 213 231
    }
}
