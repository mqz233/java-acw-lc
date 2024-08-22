package _24aug;

public class LC543 {
    public int max = 0;
    public int fnc(TreeNode root){
        if(root == null) return -1;
        int left = fnc(root.left);
        int right = fnc(root.right);
        int pathLength = left+right+2;
        if(pathLength>max) max = pathLength;
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        fnc(root);
        return max;
    }
}
