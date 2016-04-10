package hu.java.zalanmartinak;

/**
 * Created by MZ on 2016.04.07..
 */
public class Card {
    private Colour colour;
    private Number number;
    Card(Colour colour,Number number)
    {
        this.colour=colour;
        this.number=number;
    }
    public Colour getColour(){return colour;}
    public Number getNumber(){return number;}
    public boolean canPutCard(Card card)
    {
        if(colour==card.colour)return true;
        else if(number==card.number)return true;
        else if(number==Number.colourchange)return true;
        else return false;
    }
}
