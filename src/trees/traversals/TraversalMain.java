package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */

import trees.BinaryTree;

import java.util.*;

public class TraversalMain {
    public static void main(String[] args) {
        BinaryTreeTraversals<Integer> bt = new BinaryTreeTraversals<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        System.out.println("Root " + bt.root() + " and Nodes: " + bt.size());



//        System.out.println("Traversal LEVEL : ");
//        bt.print(TraversalOrder.LEVEL);
//
//        System.out.println("Traversal PRE : ");
//        bt.print(TraversalOrder.PRE);
//
//        System.out.println("Traversal POST : ");
//        bt.print(TraversalOrder.POST);
//
//        System.out.println("Traversal IN : ");
//        bt.print(TraversalOrder.IN);

        //traversals as list
        List<Integer> levelOrderList = new LinkedList<>();
        levelOrderList = bt.traverseAsList(TraversalOrder.LEVEL);
        System.out.println("Traversal LEVEL : ");
        for (int i : levelOrderList) {
            System.out.println(" " + i);
        }
        List<Integer> preOrderList = new LinkedList<>();
        preOrderList = bt.traverseAsList(TraversalOrder.PRE);
        System.out.println("Traversal PRE : ");
        for (int i : preOrderList) {
            System.out.println(" " + i);
        }

        List<Integer> postOrderList = bt.traverseAsList(TraversalOrder.POST);
        System.out.println("Traversal POST : ");
        for (int i : postOrderList) {
            System.out.println(" " + i);
        }

        System.out.println("Traversal IN : ");
        List<Integer> inOrderList= bt.traverseAsList(TraversalOrder.IN);
        for (int i : postOrderList) {
            System.out.println(" " + i);
        }

        //traverse as Iterator
        Iterator<Integer> intInOrderIterator = bt.traverseAsIterator(TraversalOrder.IN);
        System.out.println("Traversal IN : ");
        for (Iterator<Integer> it = intInOrderIterator; it.hasNext(); ) {
            System.out.println(it.next());
        }

        Iterator<Integer> intPreOrderIterator = bt.traverseAsIterator(TraversalOrder.PRE);
        System.out.println("Traversal PRE : ");
        for (Iterator<Integer> it = intPreOrderIterator; it.hasNext(); ) {
            System.out.println(it.next());
        }

        Iterator<Integer> intPostOrderIterator = bt.traverseAsIterator(TraversalOrder.POST);
        System.out.println("Traversal POST : ");
        for (Iterator<Integer> it = intPostOrderIterator; it.hasNext(); ) {
            System.out.println(it.next());
        }

        Iterator<Integer> intLevelOrderIterator = bt.traverseAsIterator(TraversalOrder.LEVEL);
        System.out.println("Traversal LEVEL : ");
        for (Iterator<Integer> it = intLevelOrderIterator; it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
