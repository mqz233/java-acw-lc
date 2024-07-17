package july;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC144 {
    public void fnc(ArrayList<Integer> res, TreeNode node) {

        res.add(node.val);
        if (node.left != null) fnc(res, node.left);
        if (node.right != null) fnc(res, node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        fnc(res, root);
        return res;

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            res.add(node.val);
            if (node.right != null) q.addFirst(node.right);
            if (node.left != null) q.addFirst(node.left);

        }
        return res;

    }
}
