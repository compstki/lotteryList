import java.util.*;

class POSTCODE {
	
    // set up a keyboard scanner for entering data
    Scanner scanner = new Scanner(System.in);
    String postCode = "";
    int players = 0;

    public POSTCODE(String postCode, int players) {
        this.postCode = postCode;
        this.players = players;
    }

    public POSTCODE(String dataRow) {
        String[] dataItems = dataRow.split(",");
        this.postCode = dataItems[0];
        // the next line MIGHT be needed, it removes trailing newline
        dataItems[1] = dataItems[1].substring(0,dataItems[1].length()-1);
        this.players = Integer.parseInt(dataItems[1]);
    }

    // procedure to check a score is between 0 and 10
    public void enterPlayers() {

        // prompt for a value
        System.out.println("Please enter players (0-10): ");

        // RECEIVE validNumber FROM (INTEGER) KEYBOARD
        players = Integer.parseInt(scanner.nextLine());

        // while validNumber < 1 OR validNumber > 10
        while ((players < 1) || (players > 10)) {

            // prompt for a value
            System.out.println("ERROR: please enter players (1-10): ");

            // RECEIVE itemToFind FROM (INTEGER) KEYBOARD
            players = Integer.parseInt(scanner.nextLine());

        } // end while

        System.out.println("Thankyou, players accepted");

    } //END PROCEDURE

    // 
    public void enterPostCode() {

        // prompt for a value
        System.out.println("Please enter a postcode ");

        //
        postCode = scanner.nextLine();

        // while 
        while ((postCode.length() < 6) ||  (postCode.length() > 7)) {

            // prompt for a value
            System.out.println("ERROR: please enter a postcode ");

            // RECEIVE 
            postCode = scanner.nextLine();

        } // end while

        System.out.println("Thankyou, postcode accepted");

    } //END PROCEDURE

    public String writePostCode()
    {
        String postCodeData = postCode + "," + String.valueOf(players);
        return(postCodeData);
    }

    public int getPlayers() {
        return players;
    }

    public String getPostCode() {
        return postCode;
    }

    public void sharePrize(int prizeFund) {
        System.out.println("Postcode: " + postCode);
        System.out.println("Players: " + players);
        System.out.println("Prize: " + (prizeFund / players));
    }

}