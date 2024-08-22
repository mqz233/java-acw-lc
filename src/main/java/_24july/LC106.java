package _24july;
import java.util.*;

/**
 * @description: 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 后序最后一个是根节点
        // 根据这个划分左子树和右子树，然后递归调用
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        // 叶子节点
        if(inorder.length == 1) return root;
        int l = 0;
        int r = inorder.length-1;
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        // index在最左边
        if(index == l){
            int[] newIorder = Arrays.copyOfRange(inorder, l + 1, r + 1);
            int[] newPostorder = Arrays.copyOfRange(postorder,l,r);
            root.right = buildTree(newIorder,newPostorder);
        }// index在最右边
        else if(index == r){
            int[] newIorder = Arrays.copyOfRange(inorder, l, r);
            int[] newPostorder = Arrays.copyOfRange(postorder,l,r);
            root.left = buildTree(newIorder,newPostorder);
        }else{
            int[] leftNewIorder = Arrays.copyOfRange(inorder, l, index);
            int[] leftNewPostorder = Arrays.copyOfRange(postorder,l,index);
            root.left = buildTree(leftNewIorder,leftNewPostorder);
            int[] rightNewIorder = Arrays.copyOfRange(inorder, index+1, r+1);
            int[] rightNewPostorder = Arrays.copyOfRange(postorder,index,r);
            root.right = buildTree(rightNewIorder,rightNewPostorder);
        }
        return root;
    }
}
