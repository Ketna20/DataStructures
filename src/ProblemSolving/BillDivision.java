package ProblemSolving;
/*
 * ketnakhalasi created on 7/28/21
 * */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;
/*
 * Complete the 'bonAppetit' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY bill
 *  2. INTEGER k
 *  3. INTEGER b
 */

public class BillDivision {

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int b = Integer.parseInt(bufferedReader.readLine().trim());

            bonAppetit(bill, k, b);

            bufferedReader.close();
        }

        public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        int sum = 0;
        int item = 0;
        int count = 0;
        for(int i : bill) {
            if(!(count == k)){
                sum += i;
            } else {
                item = i;
            }
            count++;
        }
        if (b == (sum/2)){
            System.out.println("Bon Appetit");
        }
        else {
            System.out.println(item/2);
        }

    }

}





