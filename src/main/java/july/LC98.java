package july;

/**
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效二叉搜索树定义如下：
 * 节点的左子树 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LC98 {
    int[] arr = new int[10001];
    int count = -1;
    public void fnc(TreeNode node){
        if(node == null) return;
        fnc(node.left);
        arr[++count] = node.val;
        fnc(node.right);

    }
    public boolean isValidBST(TreeNode root) {
        fnc(root);
        for(int i=0;i<count;i++){
            if(arr[i]>=arr[i+1]) return false;
        }
        return true;
    }
}
