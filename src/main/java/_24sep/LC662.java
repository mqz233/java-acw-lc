package _24sep;

import java.util.HashMap;
import java.util.Map;

public class LC662 {
    // 当前层的最左边编号
    Map<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    public void fnc(TreeNode node,int u,int depth){
        if(node == null) return;
        if(map.get(depth) == null){
            map.put(depth,u);
        }
        ans = Math.max(u-map.get(depth)+1,ans);
        fnc(node.left,u*2,depth+1);
        fnc(node.right,u*2+1,depth+1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        fnc(root,1,0);
        return ans;
    }
}
