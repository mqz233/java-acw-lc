package july;
import java.util.*;

/**
 * @description: 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class LC222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = 0;
        int r = 0;
        TreeNode node1 = root;
        while(node1.left!=null){
            node1 = node1.left;
            l++;
        }
        TreeNode node2 = root;
        while(node2.right!=null){
            node2 = node2.right;
            r++;
        }
        if(l==r){
            return (int)Math.pow(2,l+1) -1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;

    }
}
