package carl.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    // 出栈顺序和入栈顺序相反
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.left != null) {
                stack.push(tmp.right);
            }
            if (tmp.right != null) {
                stack.push(tmp.left);
            }
        }
        return res;

    }
}
