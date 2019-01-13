/**
 * Adds a new Equiptment card to the playing deck
 * @author Whitney Holmes
 */
public class EquiptmentCard extends Card {
    
    //An empty array of length 99 998
    static EquiptmentCard[] playingDeck = new EquiptmentCard[MAXLENGTH];
    //Companion variable for the array
    static int numCards = 0;

    //They are numbered 0000001 - 99999, no need for SETNUM

    /**
     * Constructor method for a Equiptment card
     * @param codeIn the numeric code for the card as an integer
     * @param nameIn the name of the card as a String
     * @param descriptionIn the description on the card, as a String
     */
    public EquiptmentCard(int codeIn, String nameIn, String descriptionIn) {
        super(codeIn, nameIn, descriptionIn);

        //Sorts the cards in the array by their code
        playingDeck[codeIn - 300000] = this;

        //Keeps track of the amount of cards of this type in the deck
        numCards ++;
    }

    /**
     * Prints out the information about the current card requested.
     * Only prints out cards that are in the playing deck
     * @param codeIn the code of the requested card
     * @return a group of strings describing the card at this time
     */
    public String DisplayCurrentCards(int codeIn ) {

        String display = "Equiptment Card:\n";

        if(playingDeck[codeIn] != null) {
            EquiptmentCard currentCard = playingDeck[codeIn];

            display += "Card #" + currentCard.getCode() + "\n";
            display += currentCard.getName() + "\n";
            display += currentCard.getDescription() + "\n";
            display += "\n";
        }
        else {
            display += "You are not currently playing that card. \n";
        }
        return display;
    }
}