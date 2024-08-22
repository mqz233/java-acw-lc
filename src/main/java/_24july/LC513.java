package _24july;
import java.util.*;

/**
 * @description: 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 */
public class LC513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
         int size = q.size();
         for(int i=0;i<size;i++){
             TreeNode node =  q.removeFirst();
             if(i==0) res = node.val;
             if(node.left!=null) q.addLast(node.left);
             if(node.right!=null) q.addLast(node.right);
         }
        }
        return res;

    }

    int depth = 0;
    int res = 0;

    public void fnc(TreeNode root,int nowDepth){
        if(nowDepth>depth){
            res = root.val;
            depth = nowDepth;
        }
        if(root.left!=null) fnc(root.left,nowDepth+1);
        if(root.right!=null) fnc(root.right,nowDepth+1);
    }

    public int findBottomLeftValue2(TreeNode root) {
        fnc(root,1);
        return res;

    }
}
