import javax.swing.*;
import java.io.*;                 
public class FILEREAD
{
    private  FileReader fReader; 

    public  String[] readCSVtable(String fileName) throws IOException {

        char[] inBuffer = new char[5000];

        
        fReader = new FileReader(fileName);
       
        // read in the data from backing storage file
        int size = fReader.read(inBuffer); 
        
        // close the file
        fReader.close();

      
        // trim the empty characters and convert the text to a string
        String fileContent = String.valueOf(inBuffer).substring(0,size);

        // convert the string to a string array by splitting into a list of rows
        return fileContent.split("\n");
    }
}