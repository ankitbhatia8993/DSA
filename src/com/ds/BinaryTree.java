package com.ds;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    /**
     * Depth First Traversals
     *   Inorder Traversal (Left-Root-Right)
     *   Preorder Traversal (Root-Left-Right)
     *   Postorder Traversal (Left-Right-Root)
     */
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }

    void inOrderWORecursion(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            node = stack.pop();
            System.out.print(node.key + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    void preOrderWORecursion(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            root = stack.pop();
            System.out.print(root.key + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    void postOrderWORecursion(Node root) {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>(), stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.empty()) {
            Node node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.empty()) {
            System.out.print(stack2.pop().key + " ");
        }
    }

    /**
     * Breadth First Traversal (Or Level Order Traversal).
     * Maximum number of nodes at level ‘l’ of a binary tree is 2^l (Index of root level is 0).
     */
    void levelOrder(Node node) {
        int heightOfTree = heightOfTree(node);
        for (int level = 0; level <= heightOfTree; level++) {
            printLevel(node, 0, level);
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

    /**
     * A Perfect Binary Tree of height h contains 2^h – 1 nodes.
     */
    int heightOfTree(Node node) {
        if (node == null) return 0;

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
