package test;
import java.util.*;

public class LC216 {

    // k个数 总和为n

    // path
    public LinkedList<Integer> path = new LinkedList<>();

    //res
    public List<List<Integer>> res = new ArrayList<>();

    public void fnc(int k, int n, int cur,int sum){
        // 必须剪枝，否则超出时间限制
        // 剪枝1 总和大于n了，直接剪掉
        if (sum>n){
            return;
        }
        if (path.size() == k ){
            // 剪枝3 size == k，不管是否和为n，都剪掉
            if (sum==n){
                res.add(new ArrayList<>(path));
            }
            return;

        }
        // i 最大为9
        // 剪枝2 剩下的数字不够了，那么后面的数字也就不用看了
        // i=9 k=3 path.size()=1
        for (int i=cur;i<=9-(k-path.size())+1;i++){
            path.add(i);
            sum+=i;
            fnc(k,n,i+1,sum);
            path.removeLast();
            sum-=i;
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {

        fnc(k,n,1,0);
        return res;

    }

}
