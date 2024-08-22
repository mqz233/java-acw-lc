package _24aug;
import java.util.*;

public class LC78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void fnc(int[] nums,int index){
        res.add(new ArrayList<>(path));
        if(path.size() == nums.length) return;
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
