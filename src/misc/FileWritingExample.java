package misc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import Spire.Doc.jar ;
import java.util.Scanner;

public class FileWritingExample {
    public static void main(String[] args) {
        try {

            File file = new File("test.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello World");
            fileWriter.close();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            if (file.createNewFile()) {
                System.out.println("File name " + file.getName() + " created.");
            } else {
                System.out.println("File not created.");
            }

        } catch(IOException e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args)
//    {
//        Path filePath = Paths.get("C:/", "temp", "test.txt");
//
//        try
//        {
//            //Write content to file
//            Files.writeString(filePath, "Hello World !!", StandardOpenOption.APPEND);
//
//            //Verify file content
//            String content = Files.readString(filePath);
//
//            System.out.println(content);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
}
