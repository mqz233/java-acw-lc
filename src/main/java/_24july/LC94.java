package _24july;
import java.util.*;

/**
 * @description:
 */
public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 尝试遍历法
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        // flag作为第二次遍历到的标记
        TreeNode flag = new TreeNode();
        while(!q.isEmpty()){
            TreeNode node = q.getFirst();
            // 第一次遍历到该节点
            // 中序 左中右
            if(node!=flag){
                q.removeFirst();
                if(node.right!=null) q.addFirst(node.right);
                q.addFirst(node);
                q.addFirst(flag);
                if(node.left!=null) q.addFirst(node.left);

            }else{
                q.removeFirst();
                TreeNode tmp = q.removeFirst();
                res.add(tmp.val);
            }
        }

        return res;


    }
}
