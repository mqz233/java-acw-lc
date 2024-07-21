package july;
import java.util.*;

/**
 * @description: 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 */
public class LC257 {
    List<String> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void fnc(TreeNode node){
        path.add(node.val);
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            for(Integer num:path){
                sb.append(num);
                sb.append("->");
            }
            res.add(sb.substring(0,sb.length()-2));
            return;
        }
        if(node.left!=null){
            fnc(node.left);
            path.removeLast();
        }
        if(node.right!=null){
            fnc(node.right);
            path.removeLast();
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        fnc(root);
        return res;
    }
}
