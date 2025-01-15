package uk.cam.mrc.phm.homework.lectures.week12.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "scenarios/homework/week12/Error.txt";
        String outputPath = "Error_output.txt";
        readData(filePath);
        //writeData(outputPath);
    }

    private static void writeData(String path) {

        try {
            PrintWriter printWriter = null;
            try{
                printWriter = new PrintWriter(path);
                printWriter.println("error 1");
                printWriter.println("error 2");
            }finally {
                if(printWriter!=null){
                    printWriter.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        }
    }

    private static void readData(String path) {
        try {
            FileReader fileReader = null;
            try{
                fileReader = new FileReader(path);
                int value = fileReader.read();
                while(value != -1){
                    System.out.print((char)value);
                    value = fileReader.read();
                }

                //Use Scanner for other read methods
//                Reader reader = new FileReader(path);
//                Scanner scanner = new Scanner(reader);
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    //int number = scanner.nextInt();
//                    System.out.println(line);
//                }

            }finally{
                if(fileReader!=null){
                    fileReader.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
