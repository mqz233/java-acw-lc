package _24aug;

public class LC230 {
    int count = 0;
    int res;
    public void fnc(TreeNode root, int k){
        if(root.left != null) fnc(root.left,k);
        if(count == k) return;
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        if(root.right != null) fnc(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        fnc(root,k);
        return res;

    }
}
