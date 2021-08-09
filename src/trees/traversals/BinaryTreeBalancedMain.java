package trees.traversals;
/*
 * ketnakhalasi created on 8/9/21
 * */

public class BinaryTreeBalancedMain {

    public static void main(String[] args) {
         /*
              40                    40
            /    \                /    \
           30     49             30     49
          /  \   /  \           /  \   /  \
         20  35 45   52        20  35 45   52
            /  \                  /  \
           34  37                34  37
              /
             36                 Balanced Tree
        Unbalanced Tree
    */
        BinaryTreeBalanced<Integer> btInt = new BinaryTreeBalanced<>();
        btInt.insert(40);
        btInt.insert(30);
        btInt.insert(49);
        btInt.insert(20);
        btInt.insert(35);
        btInt.insert(45);
        btInt.insert(52);
        btInt.insert(34);
        btInt.insert(37);
        btInt.insert(36); // if you comment this line the tree is balanced

        System.out.println("Balanced approach 1: " + btInt.isBalanced1());
        System.out.println("Balanced approach 2: " + btInt.isBalanced2());
    }
}
