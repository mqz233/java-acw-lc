package aug;

public class LC108 {
    public TreeNode fnc(int[] nums,int start,int end){
        if(start == end ) return new TreeNode(nums[start]);
        if(start>end)  return null;
        int index = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = fnc(nums,start,index-1);
        node.right = fnc(nums,index+1,end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return fnc(nums,0,nums.length-1);
    }
}
