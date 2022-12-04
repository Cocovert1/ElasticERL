import java.io.File;
import java.io.FileNotFoundException;
/*
This will find the total number of inputs and will import the data from our files.
 */

import java.util.Scanner;

public class ImportData {

    //this finds the total number of inputs
    public int nbroflines(String filename){
        int lines = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            //counts the number of lines in our file
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                lines++;
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lines;
    }

    //this will return an array of strings with the data from the files
    public String[] addData(String[] arr, String filename){
        int index = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                arr[index] = myReader.next();


                index++;
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arr;
    }
}
