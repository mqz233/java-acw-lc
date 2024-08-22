package _24aug;
import java.util.*;

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.removeFirst();
                if(node.left!=null) q.addLast(node.left);
                if(node.right!=null) q.addLast(node.right);
                if(i == size - 1) list.add(node.val);
            }
        }
        return list;


    }
}
