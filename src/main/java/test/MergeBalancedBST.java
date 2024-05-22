package test;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    int height;

    TreeNode1(int val) {
        this.val = val;
        this.height = 1;
    }
}

public class MergeBalancedBST {
    public TreeNode1 mergeTrees(TreeNode1 root1, TreeNode1 root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 将第一个二叉搜索树的所有节点插入到第二个二叉搜索树中
        insertNodes(root1, root2);

        // 重新平衡合并后的二叉搜索树
        return balanceTree(root2);
    }

    private void insertNodes(TreeNode1 node, TreeNode1 root) {
        if (node != null) {
            root = insertNode(node.val, root);
            insertNodes(node.left, root);
            insertNodes(node.right, root);
        }
    }

    private TreeNode1 insertNode(int val, TreeNode1 root) {
        if (root == null) return new TreeNode1(val);
        else if (val < root.val) root.left = insertNode(val, root.left);
        else root.right = insertNode(val, root.right);

        // 更新节点高度
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        return root;
    }

    private int getHeight(TreeNode1 node) {
        return (node == null) ? 0 : node.height;
    }

    private int balanceFactor(TreeNode1 node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private TreeNode1 rotateRight(TreeNode1 node) {
        TreeNode1 newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private TreeNode1 rotateLeft(TreeNode1 node) {
        TreeNode1 newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private TreeNode1 balanceTree(TreeNode1 root) {
        if (root == null) return null;

        // 计算平衡因子
        int balance = balanceFactor(root);

        // 左子树过重
        if (balance > 1) {
            // 左子节点的左子树过重，进行右旋转
            if (balanceFactor(root.left) >= 0)
                return rotateRight(root);
                // 左子节点的右子树过重，先左旋转再右旋转
            else {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        // 右子树过重
        else if (balance < -1) {
            // 右子节点的右子树过重，进行左旋转
            if (balanceFactor(root.right) <= 0)
                return rotateLeft(root);
                // 右子节点的左子树过重，先右旋转再左旋转
            else {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    // 中序遍历打印树
    private void inorderTraversal(TreeNode1 node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        // 示例二叉搜索树
        // 树1
        //     3
        //    / \
        //   1   5
        //
        // 树2
        //     4
        //    / \
        //   2   6

        // 构建树1
        TreeNode1 root1 = new TreeNode1(3);
        root1.left = new TreeNode1(1);
        root1.right = new TreeNode1(5);

        // 构建树2
        TreeNode1 root2 = new TreeNode1(4);
        root2.left = new TreeNode1(2);
        root2.right = new TreeNode1(6);

        MergeBalancedBST merger = new MergeBalancedBST();
        // 合并两棵树
        TreeNode1 mergedTreeRoot = merger.mergeTrees(root1, root2);

        // 输出合并后的树的中序遍历结果
        System.out.println("合并后的二叉搜索树中序遍历结果：");
        merger.inorderTraversal(mergedTreeRoot);
    }
}

