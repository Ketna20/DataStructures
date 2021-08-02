package trees;
/*
 * ketnakhalasi created on 7/30/21
 * */

public class BinaryTree {
    Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }
    public BinaryTree() {
        root = null;
    }

    public boolean insert(int data) {
        if(data == 0) {
            return false;
        }
        if (root == null) {
            root = new Node(data);
            return true;
        }

        return false;
    }
}
