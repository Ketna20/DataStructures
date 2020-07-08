package LinkedList;

import java.util.Iterator;
import java.util.function.DoubleToIntFunction;

public class LinkedListTest {

    public static void main(String[] args) {
         LinkedList<String> list = new LinkedList<String>();
         list.addFirst("p");
        list.addFirst("a");
        list.addFirst("e");
        list.addFirst("h");
        System.out.println(list); // prints h e a p

        LinkedList<String> twin = list.copy3();
        System.out.println(twin); // prints h e a p

        System.out.println(list.get(0)); // prints 'h'
       // System.out.println(list.get(4)); //exception
        System.out.println(list.get(3)); // prints 'p'

        list.addLast("s");
        System.out.println(list); // prints h e a p s

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next() + " ");
        }
        System.out.println();

        for(Object x : list) {
            System.out.println(x + " ");
        }
        System.out.println();

        list.insertAfter("e", "ee");
        System.out.println(list); //prints h e ee a p s

        System.out.println(list.getLast()); // prints s

        list.insertBefore("h", "yy");
        System.out.println(list); //prints yy h e ee a p s

        list.remove("p");
        System.out.println(list); //prints yy h e ee a s

        int len = list.getLength();
        System.out.println(len + ": length");
    }
}
