package ik.learn.sorting;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(a, target);
        for(int i : res) {
            System.out.println(i);
        }

    }

    public static int[] twoSum(int[] a, int target) {
        int i=0;
        int j=a.length -1;

        while(a[i] + a[j] != target) {
             if(a[i] + a[j] > target) {
                 j--;
             } else {
                 i++;
             }
        }
        return new int[] {i, j};
    }
}
