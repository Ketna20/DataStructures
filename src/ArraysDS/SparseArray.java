package ArraysDS;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {

    public static void main(String[] args) {
        String[] s = {"aba", "baba", "aba", "xzxb"};
        String[] q = {"aba", "xzxb", "ab"};

        matchStrings(s, q);


    }

    public static void matchStrings(String[] s, String[] q) {
        int count = 0;
        int[] res = new int[q.length];
        for (int i=0; i<q.length; i++) {
            for (int k=0; k<s.length; k++) {
                if (q[i].equals(s[k])){
                    count++;
                }
            }
            System.out.println(i + " " + count);
        }

    }


}
