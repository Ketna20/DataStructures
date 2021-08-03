package intervwPrep;
/*
 * ketnakhalasi created on 8/3/21
 * */

public class Node {
    Node left;
    Node right;
    int element;

    public Node(int element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right, int element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }
}
