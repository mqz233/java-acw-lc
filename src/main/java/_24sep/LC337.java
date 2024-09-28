package _24sep;

public class LC337 {

    // 返回一个int[]{x,y} x代表这层不选的值，y代表这层选的值
    public int[] fnc(TreeNode node){
        if(node == null) return new int[]{0,0};
        int[] l = fnc(node.left);
        int[] r = fnc(node.right);
        // 选当前元素，那么下一层只能不选了
        int not = node.val + l[0]+r[0];
        // 不选的话，下一层可以选，但不一定要选，看选是最大的，还是不选是最大的
        int yes = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[]{yes,not};

    }
    public int rob(TreeNode root) {
        int[] res = fnc(root);
        return Math.max(res[0],res[1]);
    }
}
