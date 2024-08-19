package aug;
import java.util.*;



public class LC113 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    boolean is(String s,int l,int r){
        if(l==r) return true;
        while(l<r){
           if(s.charAt(l) == s.charAt(r)){
               l++;
               r--;
           }else{
               return false;
           }
        }
        return true;
    }
    void fnc(String s,int index){
        if(index ==  s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(is(s,index,i)){
                path.add(s.substring(index,i+1));
                fnc(s,i+1);
                path.removeLast();
            }
        }

    }
    public List<List<String>> partition(String s) {
        fnc(s,0);
        return res;
    }
}
