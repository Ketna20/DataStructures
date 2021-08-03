package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */

public class Node<T> {
     Node left;
     Node right;
     T element;

    public Node(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right, T element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }


}
