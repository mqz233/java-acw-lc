package _24aug;

public class LC124 {
    int res = -1001;
    public int fnc(TreeNode node){
        if(node == null) return 0;
        int left = fnc(node.left);
        int right = fnc(node.right);
        int cur = node.val;
        if(left>0){
            cur = cur + left;
        }
        if(right>0){
            cur = cur + right;
        }
        if(cur>res){
            res = cur;
        }
        return left<=0&&right<=0?node.val: Math.max(left,right)+node.val;
//        if(left<=0&&right<=0){
//            if(node.val>res){
//                res = node.val;
//            }
//            return node.val;
//        }else{
//            if(left+right+node.val>res){
//                res = left+right+node.val;
//            }
//            return Math.max(left,right)+node.val;
//        }
//
//        return left<=0&&right<=0?node.val: Math.max(left,right)+node.val;
    }
    public int maxPathSum(TreeNode root) {
        fnc(root);
        return res;
    }
}
