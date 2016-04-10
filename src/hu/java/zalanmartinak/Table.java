package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by MZ on 2016.04.07..
 */
public class Table {
    private List<Card> throwDeck = new ArrayList<Card>();
    private List<Card> drawDeck = new ArrayList<Card>();

    Table() {
        for (int i = 0; i < 4; i++)
        {
            for(int j=0;j<12;j++)
            {
                Card card=new Card(makeColour(i),makeNumber(j));
                drawDeck.add(card);
            }
        }
        random(drawDeck);

        throwDeck.add(draw());
    }
    private void random(List<Card> deck)
    {
        Collections.shuffle(deck);
    }
    private void mix()
    {
        for(int i=0;i<throwDeck.size()-1;i++)
        {
            drawDeck.add(throwDeck.get(i));
        }
        random(drawDeck);
        Card last=throwDeck.get(throwDeck.size()-1);
        throwDeck = new ArrayList<Card>();
        throwDeck.add(last);
    }
    public void setLastCard(Card card){throwDeck.set(throwDeck.size()-1,card);}
    public Card getLastCard()
    {
        return throwDeck.get(throwDeck.size()-1);
    }
    public void throwCard(Card card)
    {
        throwDeck.add(card);
    }
    public Card draw()
    {
        if(drawDeck.size()==0)mix();
        Card card=drawDeck.get(drawDeck.size()-1);
        drawDeck.remove(drawDeck.size() - 1);
        return card;
    }
    private Colour makeColour(int i) {
        switch (i) {
            case 0:
                return Colour.red;
            case 1:
                return Colour.blue;
            case 2:
                return Colour.yellow;
            case 3:
                return Colour.green;
        }
        return Colour.red;
    }

    private Number makeNumber(int i)
    {
        switch (i)
        {
            case 0:return Number.one;
            case 1:return Number.two;
            case 2:return Number.three;
            case 3:return Number.four;
            case 4:return Number.five;
            case 5:return Number.six;
            case 6:return Number.seven;
            case 7:return Number.eight;
            case 8:return Number.nine;
            case 9:return Number.drawtwo;
            case 10:return Number.miss;
            case 11:return Number.colourchange;
        }
        return Number.miss;
    }
}
