package july;
import java.util.*;

/**
 * @description: 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class LC337 {
    public int rob(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size;i++){
                TreeNode node = q.removeFirst();
                sum += node.val;
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
            list.add(sum);
        }

        if(list.size()==1) return list.get(0);

        int[] dp = new int[list.size()];
        dp[0] = list.get(0);
        dp[1] = Math.max(dp[0],list.get(1));

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+list.get(i));
        }

        return dp[list.size()-1];
    }
}
