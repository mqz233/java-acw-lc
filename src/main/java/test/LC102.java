package test;
import java.util.*;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // root为空，直接返回
        if (root == null) return new ArrayList<>();

        ArrayList<List<Integer>> res = new ArrayList<>();

        // 使用队列
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();

        dq.addLast(root);

        while (!dq.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = dq.size();
            for (int i=0;i<size;i++){
                TreeNode treeNode = dq.removeFirst();
                tmp.add(treeNode.val);
                if (treeNode.left!=null){
                    dq.addLast(treeNode.left);
                }
                if (treeNode.right!=null){
                    dq.addLast(treeNode.right);
                }
            }
            res.add(tmp);

        }

        return res;


    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        LC102 lc102 = new LC102();
        lc102.levelOrder(treeNode);
    }
}
