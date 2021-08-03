package trees.traversals;
/*
 * ketnakhalasi created on 8/2/21
 * */

public class BinarySearchTreeTraversal<T extends Comparable<T>> {
    private int nodeCount;
    private Node root = null;

    public boolean insert(T element) {
        if(element == null) {
            return false;
        }
        if(contains(element)) {
            return false;
        }
        root = insert(root, element);
        nodeCount++;
        return true;
    }

    private Node insert(Node current, T element) {
        if(current == null) {
            return new Node(null, null, element);
        }
        if(element.compareTo((T) current.element) < 0) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current, element);
        }
        return current;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node current, T element) {
        if (root == null || element == null) {
            return false;
        }
        if(element.compareTo((T) current.element) == 0){
            return true;
        }

        return element.compareTo((T) current.element) < 0
               ? contains(current.left, element)
               : contains(current.right, element);
    }
}
