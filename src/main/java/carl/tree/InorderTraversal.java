package carl.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        TreeNode cur = root;
        if (cur == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // cur不为空证明还有未入栈的 stack不为空证明还有未弹出的
        while (cur!=null||!stack.isEmpty()){
            // 还没到二叉树根部，当前元素入栈，继续看左儿子
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                // 当前节点为null，弹出栈顶元素，加入结果集，同时cur变为栈顶元素右儿子。
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur = tmp.right;
            }
        }

        return res;

    }

}
