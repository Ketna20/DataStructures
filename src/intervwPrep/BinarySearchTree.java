package intervwPrep;
/*
 * ketnakhalasi created on 8/3/21
 * */



public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    // find The Lowest Common Ancestor of the given two nodes
    public Node lowestCommonAncestor(Node node, Integer element1, Integer element2) {
        if(element1 < node.element && element2 < node.element) {
            return lowestCommonAncestor(node.left, element1, element2);
        } else if (element1 > node.element && element2 > node.element) {
            return lowestCommonAncestor(node.right, element1, element2);
        } else {
            return node;
        }
    }

    /* check if given root of the tree is Binary Search Tree
       1. The left subtree of a node contains only nodes with key less than the node's key.
       2. The right subtree of a node contains only nodes with key more than the node's key.
       3. Both left and right subtrees are also Binary Search Trees.
     */
    public boolean checkBST(Node root) {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, Integer maxElement, Integer minElement) {
        if (node == null) {
            return true;
        } else if(minElement != null && minElement.compareTo(node.element) <= 0
        || maxElement != null && maxElement.compareTo(node.element) > 0) {
            return false;
        } else if ((!isBinarySearchTree(node.left, minElement, node.element))
        || (!isBinarySearchTree(node.right, node.element, maxElement))){
            return false;
        }
        return true;
    }

    /* Hacker Rank Solution
    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean checkBST(Node node, int min, int max) {
        if (node == null) return true;
        return  min < node.data && node.data < max &&
            checkBST(node.left, min, node.data) &&
            checkBST(node.right, node.data, max);
    }
     */
    //search an element in BST
    public Node search(Node root, int element) {
        if(root == null || root.element == element) {
            return root;
        }
        if(element < root.element) {
            return search(root.left, element);
        }

        return search(root.right, element);
    }
}
