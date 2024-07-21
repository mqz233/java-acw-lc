package july;

/**
 * @description:
 */
public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.right == null) return root.left;
            else if(root.left == null) return root.right;
            else{
                // 找右边最小
                TreeNode node = root;
                TreeNode tmp  = root.right;
                while(tmp.left!=null){
                    node = tmp;
                    tmp = tmp.left;
                }
                // tmp为右边最小 node为它的父节点
                // tmp的右子树，接到node上
                if(node != root){
                    node.left =  tmp.right;
                }else{
                    node.right =  tmp.right;
                }
                //修改root的值
                root.val = tmp.val;
            }
        }else if(key > root.val){
          if(root.right != null){
              root.right = deleteNode(root.right,key);
          }
        }else{
            if(root.left != null){
                root.left = deleteNode(root.left,key);
            }
        }
        return root;
    }
}
