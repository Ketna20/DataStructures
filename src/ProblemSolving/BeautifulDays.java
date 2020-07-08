package ProblemSolving;



public class BeautifulDays {
    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
//        int num = 20;
//        int rev = 0;
//        while (num != 0){
//            int lastDigit = num%10;
//            System.out.println("lastDigit:" + lastDigit);
//            rev = rev*10 + lastDigit;
//            num /= 10;
//        }
//        System.out.println("rev : " + rev);

    }

    static int beautifulDays(int i, int j, int k) {
        int days = 0;
       // if (k == 0) return 0;
        for(int d=i; d<=j; d++) {
            System.out.println("d: " + d);
            int rev = 0, num =d;
            while (num != 0){
                int lastDigit = num%10;
                System.out.println("lastDigit:" + lastDigit);
                rev = rev*10 + lastDigit;
                num /= 10;
            }
            System.out.println("d: " + d + "rev: " + rev);
            int value = Math.abs(rev-d);
            if(value%k == 0){
                days++;
            }
        }
        return days;
    }
}
