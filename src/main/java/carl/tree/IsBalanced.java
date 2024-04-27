package carl.tree;

public class IsBalanced {

//    public static boolean flag = true;
    public boolean isBalanced(TreeNode root) {

        int cal = cal(root);
        return cal != -1;


    }

    // 思考用哪种遍历 后续遍历，由底层节点高度计算上层节点高度，如果已经不是平衡二叉树了返回-1,否则返回此时的高度
    // 用-1代表已经出现不符合平衡二叉树的情况了
    public int cal(TreeNode n){
        if (n == null)return 0;
        int l = cal(n.left);
        if (l == -1) return -1;
        int r = cal(n.right);
        if (r == -1 ) return -1;

        return Math.abs(l-r)>1?-1:Math.max(l,r);


    }
}
