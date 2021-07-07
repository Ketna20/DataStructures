package practice.examples;
/*
 * ketnakhalasi created on 7/6/21
 * */

import java.io.*;

public class SerializationTest {

    public static void main(String[] args) {
        SerializationDemo demo = new SerializationDemo(1, "serialized");
        String fileName = "file.ser";

        //Serialization
        try {
            //save obj in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            //serialize the object
            out.writeObject(demo);
            out.close();
            file.close();
            System.out.println("object has been serialized.");
        } catch(IOException e) {
            System.out.println("IOException is caught.");
        }

        SerializationDemo demo1 = null;
        //Deserialization
        try {
            //Reading object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            //deserialize the object
            demo1 = (SerializationDemo)in.readObject();
            in.close();
            file.close();

            System.out.println("object has been deserialized.");
            System.out.println("a = " + demo1.a);
            System.out.println("b = " + demo1.b);

        } catch(IOException e) {
            System.out.println("IOException is caught.");
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught.");
        }
    }
}
