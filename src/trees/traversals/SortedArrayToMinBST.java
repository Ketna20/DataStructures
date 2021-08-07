package trees.traversals;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * ketnakhalasi created on 8/7/21
 * */
//Given sorted array of integer, create a minimal binary search tree
// minimal BST is with minimum height
public class SortedArrayToMinBST<T extends Comparable<T>> {
        private Node root = null;
        private int nodeCount;

        private class Node {
            private final T element;
            private Node left;
            private Node right;

            public Node(T element) {
                this.element = element;
                this.left = null;
                this.right = null;
            }

            public Node(T element, Node left, Node right) {
                this.element = element;
                this.left = left;
                this.right = right;
            }
        }

        // To create min height, the nodes should be
        // divided equally on both left and right sub-trees.
        private Node minimalBST(T[] a, int start, int end) {
            if(end < start) {
                return null;
            }

            int middle = (start+end) / 2;
            Node node = new Node(a[middle]);
            nodeCount++;
            node.left = minimalBST(a, start, middle-1);
            node.right = minimalBST(a, middle+1, end);

            return node;
        }

        public void minimalBST(T[] a) {
            if(a == null) {
                throw new IllegalArgumentException();
            }
            root = minimalBST(a, 0, a.length-1);
        }

        public int size() {
            return nodeCount;
        }

        public T root() {
            if(root == null) {
                return null;
            }
            return root.element;
        }
        private int height(Node node) {
            if(node == null) {
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }

        public int height() {
            return height(root);
        }

        public void print(TraversalOrder traversalOrder) {
            if(size() == 0) {
                System.out.println("The tree is empty.");
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
                    throw new IllegalArgumentException("Unrecognized Traversal Order");
            }
        }

    private void printInOrderTraversal(Node node) {
            if(node != null) {
                printInOrderTraversal(node.left);
                System.out.println(" " + node.element);
                printInOrderTraversal(node.right);
            }
    }

    private void printPreOrderTraversal(Node node) {
            if(node != null) {
                System.out.println(" " + node.element);
                printPreOrderTraversal(node.left);
                printPreOrderTraversal(node.right);
            }
    }

    private void printPostOrderTraversal(Node node) {
            if(node != null) {
                printPostOrderTraversal(node.left);
                printPostOrderTraversal(node.right);
                System.out.println(" " + node.element);
            }
    }

    private void printLevelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
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
}
