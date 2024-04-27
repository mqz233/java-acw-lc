package carl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TestAllOrder {

    // 前序遍历 中左右 入栈顺序 右左中
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tmp = new TreeNode();
        stack.addFirst(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.removeFirst();
            if (node!=tmp){
                // 右
                if (node.right!=null){
                    stack.addFirst(node.right);
                }
                // 左
                if (node.left!=null){
                    stack.addFirst(node.left);
                }
                // 中
                stack.addFirst(node);
                stack.addFirst(tmp);
            }else {
                stack.removeFirst();
                TreeNode val = stack.removeFirst();
                res.add(val.val);

            }
        }

        return res;
    }

}
