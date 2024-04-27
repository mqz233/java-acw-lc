package carl.tree;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class FindMode {
    public int[] findMode(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int count = 0;
        int max = 0;
        TreeNode pre = null;
        TreeNode cur = null;

        while (!s.isEmpty()){
            TreeNode node = s.pop();
            if (node!=null){
                if (node.right!=null){
                    s.push(node.right);
                }
                s.push(node);
                s.push(null);
                if (node.left!=null){
                    s.push(node.left);
                }
            }else {
                cur = s.pop();
                if (pre == null|| cur.val!=pre.val){
                    count = 1;
                }else {
                    count++;
                }
                if (count>max){
                    max = count;
                    res.clear();
                    res.add(cur.val);
                }else if (count == max) {
                    res.add(cur.val);
                }

                pre = cur;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
