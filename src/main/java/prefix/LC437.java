package prefix;

import java.util.*;

public class LC437 {
    //
    public Map<Long, Integer> map = new HashMap<Long, Integer>();
    int res = 0;

    public void fnc(TreeNode node, int target, long cur) {
        cur = cur + node.val;
        // 下面这两条语句的顺序不能调换
        // nums = [1] targetSum = 0
        // 如果调换，那么会错误使得res为1而不是0
        // map是给子节点用的
        res = res + map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (node.left != null) {
            fnc(node.left, target, cur);
        }
        if (node.right != null) {
            fnc(node.right, target, cur);
        }
        map.put(cur, map.get(cur) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        map.put(0L,1);
        fnc(root, targetSum, 0);
        return res;
    }
}
