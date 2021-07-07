package practice.examples;
/*
 * ketnakhalasi created on 7/6/21
 * */

import java.io.Serializable;

public class SerializationDemo implements Serializable {

    public int a;
    public String b;

    public SerializationDemo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}
