package oopconcepts.FileSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class FileSystemMain {
    public static void main(String[] args) {
        /*
        D:/
         |
         ---Docs
         |     |
         |     ---summer.txt
         |     ---winter.txt
         ---Today
                |
                ---spring.txt
         */

        Directory root = new Directory("D", null);
        Directory docs = new Directory("Docs", root);
        Directory today = new Directory("Today", root);

        File summer = new File("summer.txt", docs);
        File winter = new File("winter.txt", docs);
        File spring = new File("spring.txt", today);

        summer.setContent("Summer has long days.");
        winter.setContent("Winter is not so cold near the coast areas.");
        spring.setContent("Spring is very beautiful with lots of flowers and greenery.");

        System.out.println("D root full path: " + root.getFullPath());
        System.out.println("Today root full path: " + today.getFullPath());
        System.out.println("spring full path: " + spring.getFullPath());
    }
}
