package ik.learn.adhoc;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        boolean ans = lemonadeChange(bills);
        System.out.println(ans);
    }

    public static boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        int num20 = 0;

        for(int i=0; i<bills.length; i++) {
            if(bills[i] == 5) {
                num5++;
            }else if(bills[i] == 10) {
                num10++;
                if(num5 == 0) {
                    return false;
                }
                num5--;
            } else if(bills[i] == 20) {
                num20++;
                if(num10 > 0 && num5 > 0) {
                    num10--;
                    num5--;
                }else if(num5 >= 3) {
                    num5 -= 3;
                } else{
                    return false;
                }
            }
        }
        return true;
    }
}
