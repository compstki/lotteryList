import java.util.*;
import java.io.*;

// final version with file i/o
class Main {

    // optional hard-coded data removed

    WRITEFILE resultFile = new WRITEFILE();

    // optional file input
    FILEREAD dataFile = new FILEREAD();
    POSTCODE postCodeList[]; 
    public void setUpData() throws IOException
    {
        // read file into dataRows (contents returned as String [ ])
        String[] dataRows = dataFile.readCSVtable("postcodeData.csv");
        // store how many rows were read (size of array)
        int noOfPcodes = dataRows.length;
        // create array element space
        postCodeList = new POSTCODE[noOfPcodes];
        // now use each row from file to create postcode area object
        for (int i = 0; i < noOfPcodes; i++) {
            postCodeList[i] = new POSTCODE(dataRows[i]);
        }
    }  

    public void findMaxPlayers() {
        // set max player to first players in first postcode in list
        int maxPlayers = postCodeList[0].getPlayers();
        // repeat for the rest of the list
        for (int i = 1; i < postCodeList.length; i++) {
            // if the players in the next postcode in the list is more than max players
            if (maxPlayers < postCodeList[i].getPlayers()) {
                // update the max players to the players in the next postcode
                maxPlayers = postCodeList[i].getPlayers();
            }  // end if 
        }  // end loop
        // display the max player
        System.out.println("Max players is: " + maxPlayers);
    }

    public void countPlayers() {

    }

    public void findPostCode() {

    }

    public void storePrizes()  throws IOException
    {
        // to gather the text for file output
        String fileContent = "";
        boolean resultRowsFlag = false;
        // headings (optional)
        fileContent = fileContent + "PostCode" + "," + "Players" + "\n";
        // get string of data from rest of object
        for (int i = 0; i<postCodeList.length; i++) {
            if (((postCodeList[i].getPostCode()).substring(0,1)).equals("G")) {
                if (resultRowsFlag == true) {
                    fileContent = fileContent + "\n";
                } else {
                    resultRowsFlag = true;
                }
                fileContent = fileContent + postCodeList[i].writePostCode();                
            }
        }
        // send completed output string to the file
        resultFile.writeCSVtable("winners.csv", fileContent);
    }

    // demo: combined demos into a single method
    public void displayPrizes() {      
        int totalPrize = 0;
        for (POSTCODE nextPostCode: postCodeList) {
            if (((nextPostCode.getPostCode()).substring(0,1)).equals("G")) {
                totalPrize += 1100;
                nextPostCode.sharePrize(1100);
            }
            else
            {
                totalPrize += 1000;
                nextPostCode.sharePrize(1000);
            }
        }
        System.out.println("Total prize: " + totalPrize);
    }

    // top level algorithm
    public void processPostCode()   throws IOException 
    { 
        // enter data from file
        setUpData();
        // process data using standard algorithms
        findMaxPlayers();
        countPlayers();
        findPostCode();
        // output results
        displayPrizes();
        // save data
        storePrizes();
    }

    public static void main(String[] args)  throws IOException
    {
        Main myApp = new Main();
        myApp.processPostCode();
    }
}