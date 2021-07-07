package Streams;
/*
 * ketnakhalasi created on 8/20/20
 * */

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        String[] arr = new String[] {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        long count = stream.distinct().count();
        System.out.println(count);
    }
}
