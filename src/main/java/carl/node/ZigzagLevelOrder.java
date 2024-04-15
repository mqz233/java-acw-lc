package carl.node;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return null;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> nodes2 = new ArrayDeque<>();
        nodes.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));

        while(!nodes.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            while(!nodes.isEmpty()){
                TreeNode node = nodes.removeFirst();
                if (node.left!=null){
                    nodes2.addLast(node.left);
                    tmp.add(node.left.val);
                }
                if (node.right!=null){
                    nodes2.addLast(node.right);
                    tmp.add(node.right.val);
                }
            }
            Collections.reverse(tmp);
            if (!tmp.isEmpty()){
                res.add(tmp);
            }
            ArrayList<Integer> tmp2 = new ArrayList<>();
            while(!nodes2.isEmpty()){
                TreeNode node = nodes2.removeFirst();
                if (node.left!=null){
                    nodes.addLast(node.left);
                    tmp2.add(node.left.val);
                }
                if (node.right!=null){
                    nodes.addLast(node.right);
                    tmp2.add(node.right.val);
                }
            }
            if (!tmp2.isEmpty()){
                res.add(tmp2);
            }

        }

        return res;


    }
}
