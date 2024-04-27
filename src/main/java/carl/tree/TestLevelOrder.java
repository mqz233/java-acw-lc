package carl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TestLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()){
            int size =  q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = q.removeFirst();
                tmp.add(node.val);
                if (node.left!=null){
                    q.addLast(node.left);
                }
                if (node.right!=null){
                    q.addLast(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

