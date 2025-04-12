package edu.miracosta.cs112.lotaria;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UML CLASS DIAGRAM:
-----------------------------------------
LoteriaCard
-----------------------------------------
- cardName : String
- imageName : String
- cardNum : int
-----------------------------------------
+ LoteriaCard(cardName : String, imageName : String, cardNum : int)
+ LoteriaCard(original : LoteriaCard)
+ setAll(cardName : String, imageName : String, cardNum : int)
+ getCardName() : String
+ setCardName(cardName : String) : void
+ getImageName() : String
+ getImage() : Image
+ setImageName(imageName : String) : void
+ getCardNum() : int
+ setCardNum(carNum : int) : void
+ toString() : String
-----------------------------------------
*/

public class LoteriaCard {
    // INSTANCE VARIABLES
    private String cardName = "";
    private String imageName = "";
    private int cardNum = 0;

    //Constructor
    public LoteriaCard(String cardName, String imageName, int cardNum) {
        this.setAll(cardName, imageName, cardNum);
    }

    //Copy constructor with error checking for null values
    public LoteriaCard(LoteriaCard original) {
        if (original != null) {
            this.setAll(original.cardName, original.imageName, original.cardNum);
        } else {
            System.out.println("ERROR: trying to copy NULL object. Exiting program...");
            System.exit(1);
        }
    }

    //default constructor creates false loteria card (like Joker cards in a 52 card standard deck)
    public LoteriaCard() {
        this("EChALE STEM Logo", "0.png", 0);
    }

    // get/set methods
    public void setAll(String cardName, String imageName, int cardNum) {
        this.setCardName(cardName);
        this.setImageName(imageName);
        this.setCardNum(cardNum);
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getImageName() {
        return this.imageName;
    }

    /**
     * Gets Image object for this card by reading it from the appropriate location in a replit project
     *
     * @return returns Image object that can be used to display it in an ImageView in GUI
     **/
    public Image getImage() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("./resources/" + this.imageName);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("ERROR: could not open file.");
            System.exit(0);
        }
        return new Image(input);
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    //toString method
    @Override
    public String toString() {
        return "Loteria Card #" + this.cardNum + ": " + this.cardName + "(" + this.imageName + ")";
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (o instanceof LoteriaCard other) {
            return this.cardName.equals(other.cardName)
                    && this.cardNum == other.cardNum
                    && this.imageName.equals(other.imageName);
        }
        return false;
    }
}
