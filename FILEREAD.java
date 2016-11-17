import javax.swing.*;
import java.io.*;                 
public class FILEREAD
{

    // parameter is the name of the text file to be read
    public  String[] readCSVtable(String fileName) throws IOException {
        // set aside storage for 5000 characters from a text file
        char[] inBuffer = new char[5000];
        // open the file using a FileReader object and the file name
        FileReader fReader = new FileReader(fileName);
        // read the data from backing storage file, store the number of characters read
        int size = fReader.read(inBuffer); 
        // close the file
        fReader.close();
        // convert the text to a string, trim the empty characters 
        String fileContent = String.valueOf(inBuffer).substring(0,size);
        // convert the string to a string array by splitting into a list of rows
        return fileContent.split("\n");
    }
}