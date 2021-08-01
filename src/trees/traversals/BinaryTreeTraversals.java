package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals<T> {
    private Node root = null;
    private int nodeCount;


    //insert a node via Breadth-First Search Traversal
    public boolean insert(T element) {
        if(element == null) {
            return false;
        }
        if(root == null) {
            root = new Node(element);
            nodeCount++;
            return true;
        }
        insert(root, element);
        return true;
    }

    public void insert(Node node, T element) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();
            if(node.left == null) {
                node.left = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.left);
            }
            if(node.right == null) {
                node.right = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.right);
            }

        } //end while

    }


}
