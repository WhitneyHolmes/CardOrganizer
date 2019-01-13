import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.until.Scanner;

public class CardOrganizer extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Card Organizer");

        //Objects of the pane
        Label title = new Label("Card Organizer");
        Label enterInst = new Label("Enter a card code to place" +
                                    " in your deck:");
        Label displayInst = new Label("Enter a code code to" +
                                      " see that card:");
        TextField cardCodeIn = new TextField(" ");
        TextField cardCodeOut = new TextField(" ");

        Button enterCard = new Button("Enter");
        Button displayCard = new Button("Display");

        Text display = new Text();

        //Button actions
        enterCard.setOnAction(this::processButtonPressEnter);
        displayCard.setOnAction(this::processButtonPressDisplay);

        //Pane
        FlowPane pane = new FlowPane(title, enterInst, cardCodeIn, enterCard,
                                     displayInst, display, cardCodeOut, displayCard);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setVgap(20);

        //Set the scene
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void processButtonPressEnter(ActionEvent event) { //Action event method for entering a card

        String code = cardCodeIn.getText();
        char[] charCode = code.toCharArray;
        boolean notInt = false;

        //Makes a data base
        File file = new File("CardOrganizer.txt"); //imports file
        Scanner scan = new Scanner(file);
        Scanner lineScan;

        Card[] cardDatabase = new Card[999999]; //A database of all cards in the game

        //fill the array
        while(scan.hasNextLine()) { //scan each line
            String line = scan.nextLine();
            lineScan = new Scanner(line).setDelimeter(',');

            while(lineScan.hasNextInt()) { //pull data from each line
                int currentCode = lineScan.nextInt(); //get code
                String name = lineScan.nextString(); //get name
                String description = lineScan.nextString(); //get description
                cardDatabase[currentCode] = new Card(currentCode, name, description); //make card
            }
        }

        for(int i = 0; i < charCode.length; i ++) {
            if(((int)code[i] < 48) || ((int)code[i] > 57)) { //if not a number
                notInt = true; 
            }
        }

        if(code.isEmpty()) { //If the text field is blank
            display.setText("Please enter a code.");
        }
        else if(notInt == true) { //If there is anything but numbers
            display.setText("Only enter numbers please!");
        }
        else if((Integer.parseInt(code) > 999999) || (Integer.parseInt(code) < 0)) { //If the code is out of range
            diplay.setText("Please enter a valid code.");
        }
        else { //adds the card to the playable deck
            code = Integer.parseInt(code)
            switch(code / 100000) { //to get the first int of the code
                case 0: EquiptmentCard newCard = new EquiptmentCard(code, cardDatabase[code].getName(), 
                                                                    cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 1: CharacterCard newCard = new CharacterCard(code, cardDatabase[code].getName(),
                                                                  cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 2: FirstJobCard newCard = new FirstJobCard(code, cardDatabase[code].getName(), 
                                                                cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 3: LifeEventCard newCard = new LifeEventCard(code, cardDatabase[code].getName(),
                                                                  cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 4: CareerCard newCard = new CareerCard(code, cardDatabase[code].getName(),
                                                            cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 5: CharacterCard newCard = new CharacterCard(code, cardDatabase[code].getName(),
                                                                  cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 6: QuestCard newCard = new QuestCard(code, cardDatabase[code].getName(),
                                                          cardDatabase[code].getDescription())
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 7: TransportationCard newCard = new TransportationCard(code, cardDatabase[code].getName(),
                                                                            cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 8: PropertyCard newCard = new PropertyCard(code, cardDatabase[code].getName(),
                                                                cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                case 9: MercenaryCard newCard = new MercenaryCard(code, cardDatabase[code].getName(),
                                                                  cardDatabase[code].getDescription());
                        display.setText("Card " + code + " succesfully added.");
                        break;
                default: display.setText("Incorrect code, nothing was added.");
                        break;
            }
        }
    }

    public void processButtonPressDisplay(ActionEvent event) {

        String code = cardCodeIn.getText();
        char[] charCode = code.toCharArray;
        boolean notInt = false;

        for(int i = 0; i < charCode.length; i ++) {
            if(((int)code[i] < 48) || ((int)code[i] > 57))) { //if not a number
                notInt = true; 
            }
        }

        if(code.isEmpty()) { //If the text field is blank
            display.setText("Please enter a code.");
        }
        else if(notInt == true) { //If there is anything but numbers
            display.setText("Only enter numbers please!");
        }
        else if((Integer.parseInt(code) > 999999) || (Integer.parseInt(code) < 0)) { //If the code is out of range
            diplay.setText("Please enter a valid code.");
        }
        else {
            code = Integer.parseInt(code);

            switch(code / 100000) { //to get the first digit
                case 0: display.setText(EquiptmentCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 1: display.setText(CharacterCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 2: display.setText(FirstJobCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 3: display.setText(LifeEventCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 4: display.setText(CareerCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 5: display.setText(MonsterCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 6: display.setText(QuestCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 7: display.setText(TransportationCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 8: display.setText(PropertyCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                case 9: display.setText(MercenaryCard.DisplayCurrentCards(code)); //prints a description of the card
                        break;
                default: display.setText("That card was not found. Please enter a valid code");
                        break;
            }
        }
    }
    
}