package trees.traversals;
/*
 * ketnakhalasi created on 8/7/21
 * */

import java.util.*;

public class ListPerLevelBinaryTree<T> {
    private Node root;

    private class Node{
        private Node left;
        private Node right;
        private final T element;


        private Node(Node left, Node right, T element) {
            this.left = left;
            this.right = right;
            this.element = element;
        }

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    //insert a node via BFS
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
    private void insert(Node node, T element) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
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

    public List<List<T>> fetchAllLevels() {
        if(root == null) {
            return Collections.emptyList();
        }

        //each list holds a level
        List<List<T>> allLevels = new ArrayList<>();

        //first level (containing only the root)
        Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
        List<T> currentLevelOfElements = new ArrayList<>();

        currentLevelOfNodes.add(root);
        currentLevelOfElements.add(root.element);

        while(!currentLevelOfNodes.isEmpty()) {

            //store the current level as the previous level
            Queue<Node> previousLevelOfNode = currentLevelOfNodes;

            //add level to the final list
            allLevels.add(currentLevelOfElements);

            //go to the next level as the current level
            currentLevelOfNodes = new ArrayDeque<>();
            currentLevelOfElements = new ArrayList<>();

            // traverse all the nodes on the current level
            for(Node parent : previousLevelOfNode) {
                if(parent.left != null) {
                    currentLevelOfNodes.add(parent.left);
                    currentLevelOfElements.add(parent.left.element);
                }

                if(parent.right != null) {
                    currentLevelOfNodes.add(parent.right);
                    currentLevelOfElements.add(parent.right.element);
                }
            }

        }
        return allLevels;
    }
}
