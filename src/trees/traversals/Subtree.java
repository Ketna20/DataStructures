package trees.traversals;
/*
 * ketnakhalasi created on 8/8/21
 * */

import java.util.ArrayDeque;
import java.util.Queue;
/*  Given two binary trees, p and q,
    write a code that returns true if
    q is a subtree of p.
 */
public class Subtree<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

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

    public boolean insert(T element) {
        if(element == null) {
            return false;
        }

        if(root == null) {
            root = new Node(element);
            return true;
        }
        insert(root, element);
        return true;
    }
    //insert via BFS
    private void insert(Node node, T element) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if(node.left == null) {
                node.left = new Node(element);
                break;
            } else {
                queue.add(node.left);
            }

            if(node.right == null) {
                node.right = new Node(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }
    public boolean isSubtree(Subtree<T> q) {
        return isSubtree(root, q.root);
    }

    private boolean isSubtree(Node p, Node q) {
        if(p == null) {
            return false;
        }
        // if roots don't match
        if(!match(p, q)){
            return (isSubtree(p.left, q) || isSubtree(p.right, q));
        }

        return true;
    }

    private boolean match(Node p, Node q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

        return (p.element == q.element)
                && match(p.left, q.left)
                && match(p.right, q.right);
    }
}
