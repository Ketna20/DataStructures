package ik.learn.stack;
/*
 * ketnakhalasi created on 7/23/22
 * */
import java.util.Stack;
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";
        String path1 = "/../";
        String path2 = "/home//foo/";
        System.out.println(simplifyPath(path));
        System.out.println(simplifyPath(path1));
        System.out.println(simplifyPath(path2));
    }
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> st = new Stack<>();

        for(String dir : paths) {
            if(dir.equals(".") || dir.length() == 0)
                continue;
            else {
                if(!st.isEmpty() && dir.equals("..")) {
                    st.pop();
                } else if (st.isEmpty() && dir.equals("..")) {
                    continue;
                } else {
                    st.push(dir);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()) return "/";
        for(String s : st) {
            sb.append("/"); sb.append(s);
        }
        return sb.toString();
    }

}
