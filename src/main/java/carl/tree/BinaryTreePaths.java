package carl.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<>();
        ArrayList<Integer> paths = new ArrayList<>();
        paths.add(root.val);
        cal(root,paths,res);
        return res;

    }

    public void cal(TreeNode n,List<Integer> paths,List<String> res){
        if (n.left==null&&n.right==null){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<paths.size()-1;i++){
                str.append(paths.get(i)).append("->");
            }
            str.append(paths.get(paths.size()-1));
            res.add(str.toString());
            return;
        }
        if (n.left!=null){
            paths.add(n.left.val);
            cal(n.left,paths,res);
            paths.remove(paths.size()-1);
        }
        if (n.right!=null){
            paths.add(n.right.val);
            cal(n.right,paths,res);
            paths.remove(paths.size()-1);
        }


    }
}
