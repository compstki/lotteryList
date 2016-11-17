import java.util.*;

class POSTCODE {
    
    String postCode = "";
    int players = 0;

    // this version uses data read from file
    // parameter is a string row of csv data
    public POSTCODE(String dataRow) {
        // separate csv items into a string array
        String[] dataItems = dataRow.split(",");
        // store 1st item from the row
        this.postCode = dataItems[0];
        // the next line (optionally) needed to remove trailing newline
        dataItems[1] = dataItems[1].substring(0,dataItems[1].length()-1);
        // store last item from row
        this.players = Integer.parseInt(dataItems[1]);
    }
    
    // return properties as a string suitable for a CSV row
    public String writePostCode() {
        String postCodeData = postCode + "," + String.valueOf(players);
        return postCodeData;
    }

    public int getPlayers() {
        return players;
    }

    public String getPostCode() {
        return postCode;
    }

    // calculate and display individual prize share
    // parameter is money to be shared
    public void sharePrize(int prizeFund) {
        System.out.println("Postcode: " + postCode);
        System.out.println("Players: " + players);
        System.out.println("Prize: " + (prizeFund / players));
    }

}