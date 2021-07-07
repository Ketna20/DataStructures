package practice.examples;
/*
 * ketnakhalasi created on 7/6/21
 * */

import java.io.Serializable;

public class EmployeeSerialization implements Serializable {
    private static final long serialVersionUID = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    //Default Constructor
    public EmployeeSerialization(int a, int b, String name, int age) {
        this.a = a;
        this.b = b;
        this.name = name;
        this.age = age;
    }
}
