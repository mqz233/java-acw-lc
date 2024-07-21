package july;
import java.util.*;

/**
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LC101 {
    public boolean fnc(TreeNode l,TreeNode r){
        if(l==null && r==null) return true;
        if(l==null && r!=null) return false;
        if(l!=null && r==null) return false;
        if(l.val==r.val) {
            boolean b1 = fnc(l.left,r.right);
            boolean b2 = fnc(l.right,r.left);
            return b1 && b2;
        }
        return false;

    }

    public boolean isSymmetric(TreeNode root) {
        return fnc(root.left,root.right);
    }
}
