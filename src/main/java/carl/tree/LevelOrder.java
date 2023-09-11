package carl.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> treeNodes = new LinkedList<>();

        if (root ==null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = size; i > 0; i--) {
                TreeNode node = treeNodes.poll();
                tmp.add(node.val);
                if (node.left!=null){
                    treeNodes.offer(node.left);
                }
                if (node.right!=null){
                    treeNodes.offer(node.right);
                }
            }
            res.add(tmp);

        }

        return res;



    }
}
