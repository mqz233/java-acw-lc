package _24aug;

public class LC101 {
    public boolean fnc(TreeNode n1,TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 != null && n2 != null && n1.val == n2.val){
            boolean b1 = fnc(n1.left,n2.right);
            boolean b2 = fnc(n1.right,n2.left);
            return b1&&b2;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
      return fnc(root.left,root.right);
    }
}
