package com.ds;

import java.util.ArrayList;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        inOrder(node.left);
        inOrder(node.right);
    }

    void postOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.key + " ");
    }

    void levelOrder(Node node) {
        int currentLevel = 0;
        int heightOfTree = heightOfTree(node);
        for (int level = 0; level <= heightOfTree; level++) {
            printLevel(node, currentLevel, level);
            System.out.println();
        }
    }

    private void printLevel(Node node, int currentLevel, int level) {
        if (node == null) return;
        if (currentLevel == level)
            System.out.print(node.key + " ");
        currentLevel++;
        printLevel(node.left, currentLevel, level);
        printLevel(node.right, currentLevel, level);
    }

    int heightOfTree(Node node) {
        if (node == null) return -1;

        int left = heightOfTree(node.left);
        int right = heightOfTree(node.right);

        return (left > right) ? left + 1 : right + 1;
    }

    int sizeOfTree(Node node) {
        if (node == null) return 0;
        return sizeOfTree(node.left) + 1 + sizeOfTree(node.right);
    }

    boolean identicalTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return (identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right) && root1.key == root2.key);
        return false;
    }

    void printRootToLeafPaths(Node node, ArrayList<Integer> arrayList) {
        if (node != null) {
            arrayList.add(node.key);
            if (node.left == null && node.right == null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print(arrayList.get(i) + " ");
                }
                System.out.println();
            } else {
                printRootToLeafPaths(node.left, new ArrayList<>(arrayList));
                printRootToLeafPaths(node.right, new ArrayList<>(arrayList));
            }
        }
    }

    void printRootToLeafPaths(Node node) {
        if (node == null)
            return;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        printRootToLeafPaths(node, arrayList);
    }

    Node lowestCommonAncestor(Node node, int value1, int value2) {
        if (node == null)
            return null;

        if (node.key == value1 || node.key == value2)
            return node;

        Node left_lca = lowestCommonAncestor(node.left, value1, value2);
        Node right_lca = lowestCommonAncestor(node.right, value1, value2);

        if (left_lca != null && right_lca != null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }
}
