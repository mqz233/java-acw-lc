package aug;

public class LC114 {
    public TreeNode fnc(TreeNode node){
        if(node == null) return null;
        if(node.left==null){
          node.right =
                  fnc(node.right);
        }else{
            TreeNode tmp = node.right;
            node.right = fnc(node.left);
            // 把原右侧接到新右侧的最下面
            TreeNode n = node.right;
            while(n.right!=null) n = n.right;
            n.right = fnc(tmp);
            node.left = null;
        }
        return node;
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        fnc(root);
    }
}
