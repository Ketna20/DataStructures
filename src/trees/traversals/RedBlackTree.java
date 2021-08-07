package trees.traversals;
/*
 * ketnakhalasi created on 8/6/21
 * */

public class RedBlackTree {
    private static final int RED = 0;
    private static final int BLACK = 1;
    private final Node nil = new Node(-999);
    private Node root = nil;

    private class Node {
        int element = -999; // dummy element
        int color = BLACK;
        Node parent = null;
        Node left = null;
        Node right = null;
        private Node(int element) {
            this.element = element;
        }
    }

    //insert a node in the tree
    public void insert(int element) {
        insert(new Node(element));
    }

    private void insert(Node node) {
        Node temp = root;
        if(root == null) {
            root = node;
            node.color = BLACK;
            node.parent = null;
        } else {
            node.color = RED;
            while (true) {
                if(node.element < temp.element) {
                    if(temp.left == null) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else if(node.element >= temp.element) {
                        if(temp.right == null) {
                            temp.right = node;
                            node.parent = temp;
                            break;
                        } else {
                            temp = temp.right;
                        }
                    }
                }
            }
            fixAfterInsert(node);
        }
    }

    private void fixAfterInsert(Node node) {
       while(node.parent.color == RED) {
           Node ancestor;
           if(node.parent == node.parent.parent.left) {
               ancestor = node.parent.parent.right;
               if(ancestor != null && ancestor.color == RED){
                   node.parent.color = BLACK;
                   ancestor.color = BLACK;
                   node.parent.parent.color = RED;
                   node = node.parent.parent;
                   continue;
               }
               if(node == node.parent.right) {
                   //double rotation needed
                   node = node.parent;
                   rotateLeft(node);
               }
               node.parent.color = BLACK;
               node.parent.parent.color = RED;
               //single rotation needed
               rotateRight(node.parent.parent);
           } else {
               ancestor = node.parent.parent.left;
               if(ancestor != null && ancestor.color == RED) {
                   node.parent.color = BLACK;
                   ancestor.color = BLACK;
                   node.parent.parent.color = RED;
                   node = node.parent.parent;
                   continue;
               }
               if(node == node.parent.left) {
                   //double rotation is needed
                   node = node.parent;
                   rotateRight(node);
               }
               node.parent.color = BLACK;
               node.parent.parent.color = RED;

               //single rotation is needed
               rotateLeft(node.parent.parent);
           }
       }
        root.color = BLACK;
    }

    private void rotateRight(Node node) {
        if(node.parent !=null) {
            if(node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;

            if(node.left.right != null) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {
            // rotate the root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = null;
            root = left;
        }
    }

    private void rotateLeft(Node node) {
        if(node.parent != null) {
            if(node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }

            node.right.parent = node.parent;
            node.parent = node.right;

            if(node.right.left == null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {
            //rotate the root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = null;
            root = right;
        }
    }

    public boolean delete(int element) {
        return delete(new Node(element));
    }

    private boolean delete(Node toDelete){
        return true;
    }
}
