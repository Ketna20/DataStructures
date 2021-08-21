package intervwPrep;
/*
 * ketnakhalasi created on 8/19/21
 * */

import java.util.ArrayList;
import java.util.List;

public class AmazonFresh {

    public static void main(String[] args) {
        List<String> codeList = new ArrayList<>();
        codeList.add("apple apple");
        codeList.add("banana anything banana");
        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");

        boolean winner = winner(codeList, shoppingCart);
    }

    public static boolean winner(List<String> codeList, List<String> shoppingCart) {
        boolean win = true;
        List<String> fruits = new ArrayList<>();
        for(String fruitCode: codeList) {
            //System.out.println("fruitCode: " + fruitCode);
            if(fruitCode.contains(" ")) {
                String[] s = fruitCode.split(" ");
                for (int i=0; i< s.length; i++) {
                    fruits.add(s[i]);
                }
            } else {
                fruits.add(fruitCode);
            }
        }
        System.out.println("Fruits: " + fruits);

        for(String shop : shoppingCart) {
            System.out.println("Shopping Cart: " + shop);
        }
        System.out.println("win: " + fruits.equals(shoppingCart));



        return win;


    }



}
