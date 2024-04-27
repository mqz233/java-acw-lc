package carl.tree;

public class SumOfLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        cal(root,false);
        return sum;
    }

    public void cal(TreeNode n,boolean flag){
        if (n.left==null&&n.right==null&&flag){
            sum+=n.val;
            return;
        }
        if (n.left!=null){
            cal(n.left,true);
        }
        if (n.right!=null){
            cal(n.right,false);
        }
    }

}
