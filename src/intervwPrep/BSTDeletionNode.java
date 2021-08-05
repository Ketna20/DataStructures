package intervwPrep;
/*
 * ketnakhalasi created on 8/4/21
 * */

public class BSTDeletionNode {
    static Node root;
    static class Node {
        int key;
        Node left, right;
    }

    static Node newNode(int item) {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    //A utility function inorder traversal of the tree
    static void inOrderTraversal(Node root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.key + " ");
            inOrderTraversal(root.right);
        }
    }
    static Node insert(Node node, int key){
        // if tree is empty
        if(node == null)
            return newNode(key);
        //otherwise, recur down the tree
        if(key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return node;
    }

    static void insert(int key){
        root = insert(root, key);
    }

    static Node deleteNode(Node root, int k) {
        //base case
        if(root == null) {
            return root;
        }

        //recursive calls for the ancestors of the node to be deleted
        if(k < root.key) {
            root.left = deleteNode(root.left, k);
            return root;
        } else if(k > root.key) {
            root.right = deleteNode(root.right, k);
            return root;
        } else {
            //We reach where the node to be deleted, node with 1 or 0 child
            if(root.left != null) {
                Node temp = root.left;
                return temp;
            } else if(root.right != null) {
                Node temp = root.right;
                return temp;
            }
                //node with two children
                //get the inorder successor (smallest in the right subtree)
                if(root.right != null) {
                    root.key = minValue(root.right);
                }
                //delete the inorder successor
                root.right = deleteNode(root.right, root.key);


        }
        return root;
    }

    void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    static int minValue(Node root) {

            int minv = root.key;
            while(root.left != null) {
                minv = root.left.key;
                root = root.left;
            }
            return minv;


    }
    /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
    public static void main(String[] args) {
        BSTDeletionNode bst = new BSTDeletionNode();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("in order traversal..");
        bst.inOrderTraversal(bst.root);
        System.out.println("/n delete 20");
        bst.deleteNode(20);
        System.out.println("in order traversal after deleting 20..");
        bst.inOrderTraversal(bst.root);

        System.out.println("/n delete 30");
        bst.deleteNode(30);
        System.out.println("in order traversal after deleting 30..");
        bst.inOrderTraversal(bst.root);

        System.out.println("/n delete 50");
        bst.deleteNode(50);
        System.out.println("in order traversal after deleting 50..");
        bst.inOrderTraversal(bst.root);
    }
}
