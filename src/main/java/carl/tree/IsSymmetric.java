package carl.tree;

import java.util.Stack;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {

        // 用stack 主义出栈顺序
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null&& n2==null){
                continue;
            }
            if (n1!=null&&n2==null){
                return false;
            }
            if (n1==null&&n2!=null){
                return false;
            }
            if (n1!=null&&n2!=null&&n1.val!=n2.val){
                return false;
            }
            stack.push(n2.right);
            stack.push(n1.left);
            stack.push(n2.left);
            stack.push(n1.right);
        }

        return true;

    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetric.isSymmetric(node));

    }
}
