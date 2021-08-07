package trees.traversals;
/*
 * ketnakhalasi created on 8/7/21
 * */

public class SortedArrayToMinBstMain {

    public static void main(String[] args) {
        Integer[] a = {-2, 3, 4, 6, 7, 8, 12, 23, 90};
        SortedArrayToMinBST<Integer> minBst = new SortedArrayToMinBST<>();
        minBst.minimalBST(a);

        System.out.println("Minimal BST Root: " + minBst.root());
        System.out.println("Minimal BST height: " + minBst.height());
        System.out.println("Minimal BST nodes: " + minBst.size());

        System.out.println("Traversal Level: ");
        minBst.print(TraversalOrder.LEVEL);

        System.out.println("Traversal In: ");
        minBst.print(TraversalOrder.IN);
        System.out.println("Traversal Pre: ");
        minBst.print(TraversalOrder.PRE);
        System.out.println("Traversal Post: ");
        minBst.print(TraversalOrder.POST);
    }
}
