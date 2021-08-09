package trees.traversals;
/*
 * ketnakhalasi created on 8/8/21
 * */

import java.time.Duration;
import java.time.LocalTime;
/* An airport with single runway receives landing requests from airplane.
The request contains (landing time, minutes to complete the procedure).
Design a BST for this landing system. If the request comes in that
has overlapping time with existing request, then reject the reservation.
i.e if it has already a request of(9:56, 5minutes). The another request
comes for (10:00, 3minutes). It is overlapping since the request at 9:56
will take 5minutes to complete, so it will end at 10:01, so it cannot
take another request during that time.
 */
public class BSTLandingReservation<Temporal> {
private Node root = null;

    private class Node {
        private Node left;
        private Node right;
        private final LocalTime element;
        private final int time;

        public Node(LocalTime element, int time) {
            this.element = element;
            this.time = time;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, LocalTime element, int time) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.time = time;
        }
    }

    public void insert(LocalTime element, int time) {
        if(element == null) {
            throw new IllegalArgumentException("Requested Time is needed...");
        }
        root = insert(root, element, time);
    }

    private Node insert(Node current, LocalTime element, int time) {
        if(current == null) {
            return new Node(element, time);
        }

        long t1 = Duration.between(current.element.plusMinutes(current.time), element).toMinutes();
        long t2 = Duration.between(current.element, element.plusMinutes(time)).toMinutes();

        if(t1 <= 0 && t2 >= 0) {
            System.out.println("Cannot reserve the runway at " + element + " for " + time + " minutes");
            return current;
        }

        if(element.compareTo(current.element) < 0) {
            current.left = insert(current.left, element, time);
        } else {
            current.right = insert(current.right, element, time);
        }
        return current;
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node node) {
        if(node != null)
        {
            printInOrder(node.left);
            System.out.println(" " + node.element + "(" + node.time + ")");
            printInOrder(node.right);
        }
    }

}
