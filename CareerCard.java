/**
 * Adds a new Career card to the playing deck
 * @author Whitney Holmes
 */
public class CareerCard extends Card {
    
    //An empty array of length 99 998
    static CareerCard[] playingDeck = new CareerCard[MAXLENGTH];
    //Companion variable for the array
    static int numCards = 0;

    private final int SETNUM = 400000;

    /**
     * Constructor method for a Career card
     * @param codeIn the numeric code for the card as an integer
     * @param nameIn the name of the card as a String
     * @param descriptionIn the description on the card, as a String
     */
    public CareerCard(int codeIn, String nameIn, String descriptionIn) {
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

        String display = "Career Card:\n";

        if(playingDeck[codeIn - SETNUM] != null) {
            CareerCard currentCard = playingDeck[codeIn - SETNUM];

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