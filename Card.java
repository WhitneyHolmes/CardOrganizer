public abstract class Card {

    protected int code;
    protected String name, description;
    protected final static int MAXLENGTH = 99998;

    public Card(int codeIn, String nameIn, String descriptionIn) {
        code = codeIn;
        name = nameIn;
        description = descriptionIn;
    }

    /**
     * Gives access to the name of the card
     * @return the recorded name
     */
    public String getName() {
        return name;
    }

    /**
     * Gives access to the description of the card
     * @return the recorded description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gives access to the code of the card
     * @return the recorded code
     */
    public int getCode() {
        return code;
    }
}