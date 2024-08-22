package _24aug;

import java.util.Arrays;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // 输出: [3,9,20,null,null,15,7]
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        int index = 0;
        for(int i=0; i<inorder.length;i++){
            if(inorder[i]  == preorder[0]){
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[0]);
        if(index == 0){
            node.left = null;
        }else{
            node.left = buildTree(Arrays.copyOfRange(preorder,1,1+index),Arrays.copyOfRange(inorder,0,index));

        }
        if(index == inorder.length-1){
            node.right = null;
        }else{
            node.right = buildTree(Arrays.copyOfRange(preorder,1+index,inorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        }
        return node;

    }
}
