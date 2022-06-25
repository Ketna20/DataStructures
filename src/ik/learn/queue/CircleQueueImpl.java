package ik.learn.queue;
/*
 * ketnakhalasi created on 6/25/22
 * */

public class CircleQueueImpl {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        System.out.println("cq.enQueue(1): " + cq.enQueue(1));

        System.out.println("cq.enQueue(2): " + cq.enQueue(2));

        System.out.println("cq.enQueue(3): " + cq.enQueue(3));

        System.out.println("cq.enQueue(4):" + cq.enQueue(4));

        System.out.println("cq.rear() : " + cq.rear());

        System.out.println("cq.isFull() : "+ cq.isFull());

        System.out.println("cq.deQueue() : " + cq.deQueue());

        System.out.println("cq.enQueue(4): " + cq.enQueue(4));

        System.out.println("cq.rear() : " + cq.rear());

    }
}
