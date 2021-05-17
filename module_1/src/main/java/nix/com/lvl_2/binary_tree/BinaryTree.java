package nix.com.lvl_2.binary_tree;

public class BinaryTree {

    public TreeNode root;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public void addNode(int key) {

        TreeNode addNode = new TreeNode(key);

        if (root == null) {
            root = addNode;
        } else {
            TreeNode currentNode = root;
            TreeNode base;
            while (true) {
                base = currentNode;
                if (key < currentNode.val) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        base.left = addNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        base.right = addNode;
                        return;
                    }
                }
            }
        }
    }
}
