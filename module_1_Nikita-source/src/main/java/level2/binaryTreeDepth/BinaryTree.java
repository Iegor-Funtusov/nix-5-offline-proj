package level2.binaryTreeDepth;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        root = doInsert(root, val);
    }

    private static TreeNode doInsert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.getVal()) {
            node.setLeft(doInsert(node.getLeft(), val));
        } else if (val > node.getVal()) {
            node.setRight(doInsert(node.getRight(), val));
        }
        return node;
    }

    public int maxDepth() {
        return depth(root) - 1;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int Left = depth(root.getLeft());
        int Right = depth(root.getRight());
        return Math.max(Left, Right) + 1;
    }

}
