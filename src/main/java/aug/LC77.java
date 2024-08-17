package aug;
import java.util.*;

public class LC77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    void fnc(int n, int k,int index){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<=n - (k - path.size()) + 1;i++){
            path.add(i);
            fnc(n,k,i+1);
            path.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        fnc(n,k,1);
        return res;
    }
}
