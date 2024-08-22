package _24july;
import java.util.*;

/**
 * @description: 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class LC77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void fnc(int l,int r,int k){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=l;i<=r-(k-path.size())+1;i++){
            path.add(i);
            fnc(i+1,r,k);
            path.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        fnc(1,n,k);
        return res;
    }
}
