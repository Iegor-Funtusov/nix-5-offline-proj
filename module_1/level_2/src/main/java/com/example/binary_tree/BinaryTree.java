package com.example.binary_tree;

public class BinaryTree {
    private TreeNode root;
    private int maxDepth;

    public BinaryTree(){
        this.maxDepth = 0;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public void add(int val){
        root = addHelper(root, val);
    }

    private TreeNode addHelper(TreeNode node, int val){
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = addHelper(node.left, val);
        } else if (val > node.val) {
            node.right = addHelper(node.right, val);
        } else {
            return node;
        }
        return node;
    }

    public int getMaxDepth(){
        countDepth(root, 0);
        return maxDepth;
    }

    private void countDepth(TreeNode node, int currentDepth){
        if (node == null) {
            return;
        }
        currentDepth++;
        countDepth(node.left, currentDepth);
        System.out.print(" " + node.val);
        if(currentDepth > maxDepth)
            maxDepth = currentDepth;
        countDepth(node.right, currentDepth);
    }
}
