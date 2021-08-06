package trees.traversals;
/*
 * ketnakhalasi created on 8/2/21
 * */

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTreeTraversal<T extends Comparable<T>> {
    private int nodeCount;
    private Node root = null;

    private class Node {

        private T element;
        private Node left;
        private Node right;

        public Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

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
        if (current == null || element == null) {
            return false;
        }
        if(element.compareTo((T) current.element) == 0){
            return true;
        }

        return element.compareTo((T) current.element) < 0
               ? contains(current.left, element)
               : contains(current.right, element);
    }

    private Node delete(Node node, T element) {
        if(node == null) {
            return null;
        }

        if(element.compareTo((T) node.element) < 0) {
            node.left = delete(node.left, element);
        } else if (element.compareTo((T) node.element) > 0) {
            node.right = delete(node.right, element);
        }

        if(element.compareTo((T) node.element) == 0) {
            if(node.right == null) {
                Node left = node.left;
                node = null;
                return left;
            } else if(node.left == null) {
                Node right = node.right;
                node = null;
                return right;
            } else {
                Node leftmost = findLeftmostNode(node.right);
                node.element = leftmost.element;
                node.right = delete(node.right, (T) node.element);
            }
        }
        return node;
    }
    public boolean delete(T element) {
        if(contains(element)) {
            root = delete(root, element);
            nodeCount--;

            return true;
        }
        return false;
    }

    private Node findLeftmostNode(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node findRightmostNode(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public T root() {
        if(root == null) {
            return null;
        }
        return (T) root.element;
    }

    public T max() {
        if(root == null) {
            return null;
        }
        return (T) findRightmostNode(root).element;
    }

    public T min() {
        if(root == null) {
            return null;
        }
        return (T) findLeftmostNode(root).element;
    }

    public int size() {
        return nodeCount;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }

    public void print(TraversalOrder traversalOrder) {
        if(size() == 0) {
            System.out.println("empty");
            return;
        }

        switch (traversalOrder) {
            case IN:
                printInOrderTraversal(root);
                break;
            case PRE:
                printPreOrderTraversal(root);
                break;
            case POST:
                printPostOrderTraversal(root);
                break;
            case LEVEL:
                printLevelOrderTraversal(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized Traversal");
        }
    }

    private void printLevelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(" " + current.element);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private void printPostOrderTraversal(Node node) {
        if (node != null) {
            printPostOrderTraversal(node.left);
            printPostOrderTraversal(node.right);
            System.out.println(" " + node.element);
        }
    }


    private void printPreOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(" " + node.element);
            printPreOrderTraversal(node.left);
            printPreOrderTraversal(node.right);
        }
    }

    private void printInOrderTraversal(Node node) {
        if(node != null) {
            printInOrderTraversal(node.left);
            System.out.println(" " + node.element);
            printInOrderTraversal(node.right);
        }
    }


}
