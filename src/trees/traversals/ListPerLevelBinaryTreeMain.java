package trees.traversals;
/*
 * ketnakhalasi created on 8/7/21
 * */

public class ListPerLevelBinaryTreeMain {
    // [[40], [47, 45], [11, 13, 44, 88], [3, 1]]
    /*
              --40--
            /        \
          -47-       -45-
         /    \     /    \
        11     13  44    88
       /  \
      3    1
    */
    public static void main(String[] args) {
        ListPerLevelBinaryTree<Integer> bTree = new ListPerLevelBinaryTree<>();
        bTree.insert(40);
        bTree.insert(47);
        bTree.insert(45);
        bTree.insert(11);
        bTree.insert(13);
        bTree.insert(44);
        bTree.insert(88);
        bTree.insert(3);
        bTree.insert(1);
        System.out.println(bTree.fetchAllLevels());
    }
}
