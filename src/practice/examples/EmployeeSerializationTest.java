package practice.examples;
/*
 * ketnakhalasi created on 7/6/21
 * */

import java.io.*;

public class EmployeeSerializationTest implements Serializable {

    public static void printData(EmployeeSerialization employeeSerialization) {
        System.out.println("name = " + employeeSerialization.name);
        System.out.println("age = " + employeeSerialization.age);
        System.out.println("a = " + employeeSerialization.a);
        System.out.println("b = " + employeeSerialization.b);
    }

    public static void main(String[] args) {
        EmployeeSerialization emp1 = new EmployeeSerialization(1, 2, "KK", 45);
        String fileName = "kk.txt";

        //Serialization
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(emp1);
            out.close();
            file.close();
            System.out.println("EmployeeSerialization Object is serialized.\n " +
                    "Data before Deserialization:");
            printData(emp1);

            //Static variable value is changed.
            emp1.b = 30;

        } catch (IOException e) {
            System.out.println("IOException is caught.");
        }

        //Deserialization
        emp1 = null;
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            emp1 = (EmployeeSerialization) in.readObject();
            in.close();
            file.close();
            System.out.println("EmployeeSerialization Object is Deserialized");
            printData(emp1);
        } catch (IOException e) {
            System.out.println("IOException is caught.");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught.");
        }




    }
}
