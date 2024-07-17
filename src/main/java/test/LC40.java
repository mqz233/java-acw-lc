package test;
import java.util.*;

// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用 一次 。
//
//注意：解集不能包含重复的组合。
//
//
//
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//

public class LC40 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    int[] used = new int[100];


    public void fnc(int[] candidates, int target,int index,int sum){

        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(used[path.size()] == candidates[i]){
                continue;
            }
            used[path.size()] = candidates[i];
            if(sum + candidates[i] > target) break;
            sum += candidates[i];
            path.add(candidates[i]);
            fnc(candidates,target,i+1,sum);
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        fnc(candidates,target,0,0);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC40().combinationSum2(new int[]{5,4,5,1,5,3,1,4,5,5,4}, 10);
    }
}
