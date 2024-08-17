package aug;
import java.util.*;

public class LC216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    void fnc(int k,int n,int index,int sum){
        if(sum > n) return;
        if(path.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=index;i<= 9 - (k-path.size())+1;i++){
            sum+= i;
            path.add(i);
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
