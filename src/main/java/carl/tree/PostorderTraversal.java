package carl.tree;

import java.util.*;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null)
        {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        // 前序遍历反着来
        // 分析什么时候出栈
        // 为什么用set记录访问过的node
        while (!stack.isEmpty()){
            TreeNode tmp =stack.peek();
            if (tmp.left==null&&tmp.right==null||set.contains(tmp)){
                res.add(stack.pop().val);
                continue;
            }
            set.add(tmp);
            if (tmp.right!=null){
                stack.push(tmp.right);
            }
            if (tmp.left!=null){
                stack.push(tmp.left);
            }

        }

        return res;

    }
}
