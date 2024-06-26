package trees.traversals;
/*
 * ketnakhalasi created on 8/6/21
 * */

public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(3);
        maxHeap.add(32);
        maxHeap.add(1);
        maxHeap.add(10);
        maxHeap.add(82);
        maxHeap.add(-2);
        maxHeap.add(13);
        maxHeap.add(63);
        maxHeap.add(21);
        maxHeap.add(93);
        maxHeap.add(8);

        System.out.println("Print Heap: ");
        maxHeap.printHeap();

        while(maxHeap.size() > 0) {
            int size = maxHeap.size();
            int peek = maxHeap.peek();
            int poll = maxHeap.poll();
            System.out.println("Peek: " + peek + " Poll: " + poll + " Size: " + size);

            System.out.println("Print Heap: ");
            maxHeap.printHeap();

        }



    }
}
