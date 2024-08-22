package _24aug;
import java.util.*;

public class LC98 {
    public List<Integer> res = new ArrayList<>();
    public void fnc(TreeNode node){
        if(node.left!= null) fnc(node.left);
        res.add(node.val);
        if(node.right!= null) fnc(node.right);

    }
    public boolean isValidBST(TreeNode root) {
        fnc(root);
        if(res.size()==1) return true;
        for(int i=0; i<res.size()-1;i++){
            if(res.get(i)>=res.get(i+1)) return false;
        }
        return true;

    }
}
