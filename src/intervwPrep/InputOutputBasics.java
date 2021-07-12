package intervwPrep;
/*
 * ketnakhalasi created on 7/11/21
 * */


import java.io.Console;
import java.util.Scanner;

public class InputOutputBasics {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("enter a String: ");
//        String word = in.next();

        //for username and password
        Console cons = System.console();
        System.out.println("Enter user name: ");

        String userName = cons.readLine("UserName: ", args[0]);
        char[] password = cons.readPassword("Password: ", args[1]);

        System.out.println("UserName: " + userName);
        System.out.println("Password: " + password);
     //   System.out.println("word: " + word);
    }
}
