package com.ds;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.left.left.left = new Node(6);

        System.out.print("Inorder traversal : ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();

        System.out.print("Preorder traversal : ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();

        System.out.print("Postorder traversal : ");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();

        System.out.println("\nSize of tree : " + binaryTree.sizeOfTree(binaryTree.root) + "\n");
        System.out.println("Height of tree : " + binaryTree.heightOfTree(binaryTree.root) + "\n");

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.root = new Node(1);
        binaryTree2.root.left = new Node(2);
        binaryTree2.root.right = new Node(3);
        binaryTree2.root.left.left = new Node(4);
        binaryTree2.root.left.right = new Node(5);
        binaryTree2.root.left.left.left = new Node(7);

        System.out.println("Are both trees identical? Answer: " + binaryTree.identicalTrees(binaryTree.root, binaryTree2.root) + "\n");

        System.out.println("Root to leaf paths : ");
        binaryTree.printRootToLeafPaths(binaryTree.root);
        System.out.println();

        System.out.println("Lowest common ancestor : " + binaryTree.lowestCommonAncestor(binaryTree.root, 5  , 6).key + "\n");
    }
}
