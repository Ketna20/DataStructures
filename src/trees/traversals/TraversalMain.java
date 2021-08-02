package trees.traversals;
/*
 * ketnakhalasi created on 8/1/21
 * */

import trees.BinaryTree;

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

        System.out.println("Traversal LEVEL : ");
        bt.print(TraversalOrder.LEVEL);

        System.out.println("Traversal PRE : ");
        bt.print(TraversalOrder.PRE);

        System.out.println("Traversal POST : ");
        bt.print(TraversalOrder.POST);

        System.out.println("Traversal IN : ");
        bt.print(TraversalOrder.IN);
    }
}
