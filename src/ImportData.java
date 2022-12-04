import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportData {

    public int nbroflines(String filename){
        int lines = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
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
