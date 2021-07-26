package ArraysDS;
/*
 * ketnakhalasi created on 7/24/21
 * */

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        // int[] numbers = {2, 7, 11, 15};
        int[] numbers = {3, 2, 4};
        int[] result = twoSum(numbers, 6);
        for(int m=0; m<result.length; m++) {
            System.out.println(result[m]);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i< nums.length; i++) {
            for(int k= 1; k<nums.length; k++) {
                if(nums[i] + nums[k] == target){
                    indices[i] = i;
                    indices[k] = k;
                }
            }
        }
        return indices;
    }
}
