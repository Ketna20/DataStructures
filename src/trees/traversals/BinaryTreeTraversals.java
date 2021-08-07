package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */

import java.util.*;

public class BinaryTreeTraversals<T> {
    private Node root = null;
    private int nodeCount;

    private class Node {
        Node left;
        Node right;
        T element;

        private Node(T element) {
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

    public Iterator<T> traverseInOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        return new Iterator<T>() {
            Node cursor = node;
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor != null && cursor.left != null) {
                    stack.push(cursor.left);
                    cursor = cursor.left;
                }
                Node current = stack.pop();
                if(current.right != null) {
                    stack.push(current.right);
                    cursor = current.right;
                }

                return (T) current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Removing a node is not supported.");
            }
        };
    }

    public Iterator<T> traversePreOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                Node current = stack.pop();
                if(current.right != null) {
                    stack.push(current.right);
                }
                if(current.left != null) {
                    stack.push(current.left);
                }
                return (T) current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Removal of node is not supported.");
            }
        };
    }

    public Iterator<T> traversePostOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Deque<Node> stack_a = new ArrayDeque<>();
        final Deque<Node> stack_b = new ArrayDeque<>();
        stack_a.push(node);

        while(!stack_a.isEmpty()){
            Node node1 = stack_a.pop();
            if(node1 != null) {
                stack_b.push(node1);
                if(node1.left != null) {
                    stack_a.push(node1.left);
                }
                if(node1.right != null) {
                    stack_a.push(node1.right);
                }
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null && !stack_b.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) stack_b.pop().element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<T> traverseLevelOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(expectedNodeCount != nodeCount){
                    throw new ConcurrentModificationException();
                }
                return node != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }
                Node current = queue.poll();
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                return (T) current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<T> traverseAsIterator(TraversalOrder traversalOrder) {
        if(size() == 0) {
            return Collections.emptyIterator();
        }
        switch (traversalOrder) {
            case IN:
                return traverseInOrderAsIterator(root);
            case PRE:
                return traversePreOrderAsIterator(root);
            case POST:
                return traversePostOrderAsIterator(root);
            case LEVEL:
                return traverseLevelOrderAsIterator(root);
            default:
                throw new IllegalArgumentException("Unrecognized Traversal Order.");
        }
    }

}
