package test;

import java.util.ArrayDeque;

public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.addLast(root);
        int count = 0;
        while (!q.isEmpty()){
            count++;
            for (int i=0; i<q.size(); i++){
                TreeNode node = q.removeFirst();
                if(node.left != null){
                    q.addLast(node.left);
                }
                if(node.right!=null){
                    q.addLast(node.right);
                }
            }
        }
        return count;

    }

    public int maxDepth = 0;
    public void fnc(TreeNode node, int depth){

        if (node == null){
            if (depth>maxDepth){
                maxDepth = depth;
            }
            return;
        }
        depth++;
        if (node.left!=null){
            fnc(node.left,depth);
        }
        if (node.right!=null){
            fnc(node.right,depth);
        }

    }

    public int maxDepth2(TreeNode root) {
        fnc(root,0);
        return maxDepth;
    }
}
