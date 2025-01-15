package uk.cam.mrc.phm.homework.lectures.week12.io;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedReaderExample {
    public static void main(String[] args) {
        String filePath = "scenarios/homework/week12/Error.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String newLine;
            //read header and find index for each column.
            String header = bufferedReader.readLine();
            String[] headerArray = header.split(",");
            int indexId = findIndexInArray(headerArray,"ErrorId");
            int indexType = findIndexInArray(headerArray,"ErrorType");
            int indexMessage = findIndexInArray(headerArray,"ErrorMessage");

            //read body
            while((newLine = bufferedReader.readLine())!=null){

                String[] strings = newLine.split(",");
                ErrorExample errorExample = new ErrorExample();
                errorExample.setId(Integer.parseInt(strings[indexId]));
                errorExample.setType(strings[indexType]);
                errorExample.setMessage(strings[indexMessage]);

                System.out.print(errorExample.getId());
                System.out.println();
                System.out.print(errorExample.getType());
                System.out.println();
                System.out.println(errorExample.getMessage());
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            readFile(filePath);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
            ArrayList<String[]> lines = new ArrayList<>();
        String newLine;
        while ((newLine = br.readLine()) != null) {
            String[] newlineSplit = newLine.split("[ ,.]+");
            lines.add(newlineSplit);
            System.out.println(newLine);

        }
        br.close();
    }


    private static int findIndexInArray( String[] str,String colname) {
        int position = -1;
        for (int a =0; a<str.length;a++){
            if(str[a].equalsIgnoreCase(colname)){
                position = a;
            }
        }

        if (position == -1){
            throw new RuntimeException("Could not find column called: " + colname);
        }
        return position;
    }
}
