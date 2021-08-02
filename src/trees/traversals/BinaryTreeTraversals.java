package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */


import sun.awt.image.ImageWatched;

import java.util.*;

public class BinaryTreeTraversals<T> {
    private Node root = null;
    private int nodeCount;

    public T root() {
        if(root == null) {
            return null;
        }
        return (T) root.element;
    }

    public int size() {
        return nodeCount;
    }

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

    public void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
           // step 1: pop the first node from the queue as the current node
           Node current = queue.poll();
           //step 2: visit the current node
           System.out.println(" " + current.element);
           //step 3: if the current node has left node then enqueue that left node
           if(current.left != null) {
               queue.add(current.left);
           }
           //step 4: if the current node has a right node then enqueue that right node
           if(current.right != null) {
               queue.add(current.right);
           }
        } // end while
    }

    public void printInOrder(Node node) {
        if(node != null) {
            printInOrder(node.left);
            System.out.println(" " + node.element);
            printInOrder(node.right);
        }
    }

    public void printPreOrder(Node node) {
        if(node != null) {
            System.out.println(" " + node.element);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder(Node node) {
        if(node != null) {
            printPreOrder(node.left);
            printPreOrder(node.right);
            System.out.println(" " + node.element);
        }
    }

    public void print(TraversalOrder traversalOrder) {
        if(size() == 0) {
            System.out.println("Tree is Empty");
            return;
        }
        switch (traversalOrder) {
            //DFS
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            //BFS
            case LEVEL:
                printLevelOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    //traverse In-Order as List
    public void traverseInOrderAsList(Node node, List<T> treeList) {
        if(node != null) {
            traverseInOrderAsList(node.left, treeList);
            treeList.add((T) node.element);
            traverseInOrderAsList(node.right, treeList);
        }
    }

    //traverse Pre-Order as List
    public void traversePreOrderAsList(Node node, List<T> treeList) {
        treeList.add((T) node.element);
        if(node.left != null) {
            traversePreOrderAsList(node.left, treeList);
        }
        if(node.right != null) {
            traversePreOrderAsList(node.right, treeList);
        }
    }

    //traverse Post-Order as List
    public void traversePostOrderAsList(Node node, List<T> treeList) {
        if(node.left != null) {
            traversePostOrderAsList(node.left, treeList);
        }
        if(node.right != null) {
            traversePostOrderAsList(node.right, treeList);
        }

        treeList.add((T) node.element);
    }

    //traverse Level Order as list
    public void traverseLevelOrderAsList(Node node, List<T> treeList) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            treeList.add((T) current.element);

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        } // end while
    }

    public List<T> traverseAsList(TraversalOrder traversalOrder) {
        if(size() == 0) {
            return Collections.emptyList();
        }

        List<T> treeList = new ArrayList<>(size());
        switch(traversalOrder) {
            case IN:
                traverseInOrderAsList(root, treeList);
                break;
            case PRE:
                traversePreOrderAsList(root, treeList);
                break;
            case POST:
                traversePostOrderAsList(root, treeList);
                break;
            case LEVEL:
                traverseLevelOrderAsList(root, treeList);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized Traversal order...");
        }
        return treeList;
    }

}
