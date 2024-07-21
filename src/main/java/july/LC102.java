package july;
import java.util.*;

/**
 * @description: TODO
 */
public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
         if(root==null) return new ArrayList<>();
         ArrayDeque<TreeNode> q = new ArrayDeque<>();
         ArrayList<List<Integer>> res  = new ArrayList<>();
         q.addLast(root);
         while(!q.isEmpty()){
             ArrayList<Integer> tmp = new ArrayList<>();
             int size = q.size();
             for(int i=0; i<size;i++){
                 TreeNode node = q.removeFirst();
                 tmp.add(node.val);
                 if(node.left!=null) q.addLast(node.left);
                 if(node.right!=null) q.addLast(node.right);
             }
             res.add(tmp);
         }
         return res;
    }
}
