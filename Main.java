import java.util.*;
import java.io.*;

class Main {

    // optional hard-coded data, useful for early testing
    //POSTCODE postCodeA = new POSTCODE("EH477LX", 3);
    //POSTCODE postCodeB = new POSTCODE("EH461AB", 2);
    //POSTCODE postCodeC = new POSTCODE("G213CF", 5);
    //POSTCODE postCodeD = new POSTCODE("EH482TR", 1);
    //POSTCODE postCodeE = new POSTCODE("G168AS", 1);
    //POSTCODE postCodeList[]= {postCodeA, postCodeB, postCodeC, postCodeD, postCodeE};

    // to gather the text for file output
    String fileContent = "";
    WRITEFILE resultFile = new WRITEFILE();

    // optional file input
    FILEREAD dataFile = new FILEREAD();
    POSTCODE postCodeList[]; 
    public void setUpData() throws IOException
    {
        // optional developer info
        System.out.println("** Prepering to read data file");

        // request file to be read and data row contents returned as as String array
        String[] dataRows = dataFile.readCSVtable("postcodeData.csv");
        // store a count of how many rows were read (number of array elements)
        int noOfPcodes = dataRows.length;

        // optional developer info
        System.out.println("** " + noOfPcodes + " rows read.\n\n");

        // no headings so don't read a header row

        // create array element space
        postCodeList = new POSTCODE[noOfPcodes];

        // now use each row from file to create postcode area object
        for (int i = 0; i < noOfPcodes; i++) {
            postCodeList[i] = new POSTCODE(dataRows[i]);
        }
    }
    // optional keyboard input
    public void enterPostCodeData() {
        // a "for each" loop, no index required, just a placeholder variable
        for (POSTCODE nextPostCode: postCodeList) {
            nextPostCode.enterPlayers();
            nextPostCode.enterPostCode();
        }
    }
    // optional keyboard input
    public void enterPostCodeData2() {
        // traditional index based for loop
        for(int i = 0; i < 5; i++) { 
            postCodeList[i].enterPlayers();
            postCodeList[i].enterPostCode();
        }
    }
    // optional keyboard input
    public void enterPostCodeData3() {
        // using a conditional loop with explicit counter as array index
        int counter = 0;
        while (counter < 5) {
            postCodeList[counter].enterPlayers();
            postCodeList[counter].enterPostCode();
            counter++;
        }
    }   

    public void findMaxPlayers() {
        // set max player to first players in first postcode in list
        int maxPlayers = postCodeList[0].getPlayers();
        // repeat for the rest of the list
        for (int i = 1; i < 5; i++) {
            // if the players in the next postcode in the list is more than max players
            if (maxPlayers < postCodeList[i].getPlayers()) {
                // update the max players to the players in the next postcode
                maxPlayers = postCodeList[i].getPlayers();
                // end if
            }
            // end loop 
        }
        // display the max player
        System.out.println("Max players is: " + maxPlayers);
    }

    public void countPlayers() {

    }

    public void findPostCode() {

    }

    public void storePrizes()  throws IOException
    {
        // headings
        fileContent = fileContent + "PostCode" + "," + "Players" + "\n";
        if (((postCodeList[0].getPostCode()).substring(0,1)).equals("G")) {
            // get string of data from first object
            fileContent = fileContent + postCodeList[0].writePostCode();
        }
        // get string of data from rest of object
        for (int i = 1; i<postCodeList.length; i++) {
            if (((postCodeList[i].getPostCode()).substring(0,1)).equals("G")) {
                fileContent = fileContent + "\n" + postCodeList[i].writePostCode();
            }
        }
        // send completed output string to the file
        resultFile.writeCSVtable("winners.csv", fileContent);
    }
    // demo: call sharePrize to display prize for every postcode area
    public void displayPrizes1() {
        for (POSTCODE nextPostCode: postCodeList) {
            nextPostCode.sharePrize(1000);
        }
    }
    // demo: display prizes for "G" (Glasgow) postcode area only
    public void displayPrizes2() {
        for (POSTCODE nextPostCode: postCodeList) {
            if (((nextPostCode.getPostCode()).substring(0,1)).equals("G")) {
                nextPostCode.sharePrize(1100);
            }
            else
            {
                nextPostCode.sharePrize(1000);
            }
        }
    }
    // demo: sum total conditional on postcode area
    public void displayPrizes3() {
        int totalPrize = 0;
        for (POSTCODE nextPostCode: postCodeList) {
            if (((nextPostCode.getPostCode()).substring(0,1)).equals("G")) {
                totalPrize += 1100;
            }
            else
            {
                totalPrize += 1000;
            }
        }
        System.out.println("Total prize: " + totalPrize);
    }
    // demo: combine previous demos into a single method
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
        //enterPostCodeData();
        setUpData();
        findMaxPlayers();
        countPlayers();
        findPostCode();
        displayPrizes();
        storePrizes();
    }

    public static void main(String[] args)  throws IOException
    {
        Main myApp = new Main();
        myApp.processPostCode();
    }
}