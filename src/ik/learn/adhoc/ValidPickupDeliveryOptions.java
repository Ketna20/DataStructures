package ik.learn.adhoc;
/*
 * ketnakhalasi created on 9/5/22
 * Given n orders, each order consist in pickup and delivery services.
Count all valid pickup/delivery possible sequences such that delivery(i)
* is always after of pickup(i).
Since the answer may be too large, return it modulo 10^9 + 7.
* n=1 , output = 1
* Input: n = 2
Output: 6
Explanation: All possible orders:
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1)
* and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
 * */

public class ValidPickupDeliveryOptions {
    public static void main(String[] args) {
        int ans = countOrders(9);
        System.out.println("ans: " + ans);
    }

    public static int countOrders(int n) {
        // int mod = 1000000007;
        // long ans = 1, sum = 0;
        // for(int i=0;i<n;i++){
        //     sum += (4*i+1);
        //     ans = (ans*sum)%mod;
        // }
        // return (int)(ans%mod);
        int f=1;
        for(int i=2; i<n+1; i++) {
            f = (f*i*(2*i-1)) % 1000000007;
        }
        return f;
    }

}
