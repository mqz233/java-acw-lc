package aug;

import java.util.*;


public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        q.addLast(root);
        TreeNode flag = new TreeNode();
        while(!q.isEmpty()){
            TreeNode node = q.removeLast();
            if(node != flag){
                if(node.right != null){
                    q.addLast(node.right);
                }
                q.addLast(node);
                q.addLast(flag);
                if(node.left!= null){
                    q.addLast(node.left);
                }
            } else{

                res.add(q.removeLast().val);
            }
        }

        return res;

    }
}
