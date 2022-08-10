package ik.learn.arrays;
/*
 * ketnakhalasi created on 7/28/22
 * */

public class CircularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        boolean isCircular = circularArrayLoop1(nums);
        System.out.println("is Circular: " + isCircular);
    }

    public static boolean circularArrayLoop1(int[] nums) {
        boolean[] vis = new boolean[nums.length];

        for(int i =0 ; i < nums.length ; i++)
        {
            if(!vis[i] && checkCycle(nums,i,vis) == true)
                return true;
        }
        return false;
    }

    public static boolean checkCycle(int[] nums, int i, boolean[] vis)
    {
        vis[i] = true; // mark this position as visited
        int fast = i; //for cycle detection
        int slow = i;//for cycle detection
        int n = nums.length;


        fast = (fast + nums[fast] + 1000*n)%n; //this equation will guarantee that I always stay within the array boundries the 1000 is because the smallest negative elment in the array is -1000
        vis[fast] = true; // mark every visited pos with true
        fast = (fast + nums[fast] + 1000*n)%n;//3,0,1,3,1
        vis[fast] = true;
        slow = (slow + nums[slow] + 1000*n)%n;//3.0

        while(fast != slow)
        {
            fast = (fast + nums[fast] + 1000*n)%n;
            vis[fast] = true;
            fast = (fast + nums[fast] + 1000*n)%n;//3,0,1,3,1
            vis[fast] = true;
            slow = (slow + nums[slow] + 1000*n)%n;//3.0
        }
        //now fast == slow we found the start of our cycle
        //validate the cycle

        int start = slow;

        slow = (slow + nums[slow] + 1000*n)%n;
        //get the sign of the initial pos
        boolean startSign = (nums[start] > 0);


        //one elment loop
        if(slow == start)
        {
            return false;
        }

        while(slow != start)
        {
            boolean currentSign = (nums[slow] > 0);

            if(currentSign != startSign )
            {
                return false;
            }

            slow = (slow + nums[slow] + 1000*n)%n;

        }
        return true;
    }


    public static boolean circularArrayLoop(int[] nums) {

        int len = nums.length;

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) continue;
            int hare = i;
            int tortoise = i;
            while(true){
                hare = move(move(i, nums), nums);
                tortoise = move(i, nums);
                if(hare == tortoise) {  //cycle detected
                    // check if it is a special cylce
                    int third = tortoise;

                    int count = 1;  // stores cycle length
                    boolean positive = true;
                    if(nums[third]< 0){
                        positive = false;
                    }

                    while(move(third, nums) != tortoise) {
                        third = move(third, nums);
                        count++;
                        if((nums[third] < 0 && positive) ||(nums[third] > 0 && !positive)) {
                            count = 1;
                            break;
                        }
                    }
                    if(count ==1) {
                        third = i;
                        while(nums[third] != 0){
                            int next = move(third, nums);
                            nums[third] = 0;
                            third = next;
                        }
                        break;
                    }else {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public static int move(int x, int[] nums) {
        return (x + nums[x]) % nums.length;
    }
}
