package _24sep;

public class LC51 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public int res = Integer.MIN_VALUE;
//        public int fnc(TreeNode node){
//            if(node == null) return 0;
//            int l = fnc(node.left);
//            int r = fnc(node.right);
//            if(l<0) l=0;
//            if(r<0) r=0;
//            if(l+r+node.val>res){
//                res = l+r+node.val;
//            }
//
//            if(l>r){
//                return l+node.val;
//            }else{
//                return  r+node.val;
//            }
//        }
//
//        public int maxPathSum(TreeNode root) {
//            fnc(root);
//            return res;
//
//        }
//    }
}
