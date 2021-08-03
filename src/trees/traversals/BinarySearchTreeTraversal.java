package trees.traversals;
/*
 * ketnakhalasi created on 8/2/21
 * */

public class BinarySearchTreeTraversal<T extends Comparable<T>> {
    private int nodeCount;
    private Node root = null;

    private boolean contains(Node current, T element) {
        if(root == null || element == null) {
            return false;
        }
        if(element.compareTo((T) current.element) == 0) {
            return true;
        }
        return element.compareTo((T) current.element) < 0 ?
                contains(current.left, element) :
                contains(current.right, element);
    }

    public boolean contains(T element) {
        return contains(root, element);

    }
}
