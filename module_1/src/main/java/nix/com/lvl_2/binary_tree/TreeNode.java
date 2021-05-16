package nix.com.lvl_2.binary_tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int Left = maxDepth(root.left);

        int Right = maxDepth(root.right);

        return Math.max(Left,Right) + 1;

    }
}
