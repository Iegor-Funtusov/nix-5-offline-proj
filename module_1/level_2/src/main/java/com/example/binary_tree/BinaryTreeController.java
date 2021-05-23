package com.example.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;

public class BinaryTreeController {
    private final BufferedReader reader;

    public BinaryTreeController(BufferedReader reader){
        this.reader = reader;
    }

    public void depthOfBinaryTree() throws IOException {
        System.out.println("Manual or Automatically generation binary tree? " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                BinaryTree tree = manualSetBinaryTree();
                System.out.println("\nMax depth: " + tree.getMaxDepth());
                break;
            }
            case "2":{
                BinaryTree tree = automaticallySetBinaryTree();
                System.out.println("\nMax depth: " + tree.getMaxDepth());
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                depthOfBinaryTree();
            }
        }
    }

    private BinaryTree manualSetBinaryTree() throws IOException {
        BinaryTree tree = new BinaryTree();
        System.out.println("Enter size of binary tree: ");
        int size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) {
            if(i == 0){
                System.out.print("root el: ");
            } else {
                System.out.print("EL" + i + ": ");
            }
            int val = Integer.parseInt(reader.readLine());
            tree.add(val);
        }
        return tree;
    }

    private BinaryTree automaticallySetBinaryTree() throws IOException {
        BinaryTree tree = new BinaryTree();
        System.out.println("Enter size of binary tree: ");
        int size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) {
            int val = (int) (Math.random() * 50);
            tree.add(val);
        }
        return tree;
    }
}
