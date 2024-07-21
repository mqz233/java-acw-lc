package july;
import java.util.*;

/**
 * @description: 给定一个二叉树，判断它是否是平衡二叉树
 *
 *
 *
 */
public class LC110 {
    public int fnc(TreeNode root){
        if(root==null) return 0;
        int l = fnc(root.left);
        int r = fnc(root.right);
        if (l==-1) return -1;
        if (r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;

    }
    public boolean isBalanced(TreeNode root) {
        return fnc(root)!=-1;
    }
}
