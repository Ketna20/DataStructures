package intervwPrep;
/*
 * ketnakhalasi created on 8/3/21
 * */



public class BinarySearchTree<T> {
    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    // find The Lowest Common Ancestor of the given two nodes
    public Node lowestCommonAncestor(Node node, int element1, int element2) {
        if(element1 < node.element && element2 < node.element) {
            return lowestCommonAncestor(node.left, element1, element2);
        } else if (element1 > node.element && element2 > node.element) {
            return lowestCommonAncestor(node.right, element1, element2);
        } else {
            return node;
        }
    }


}
