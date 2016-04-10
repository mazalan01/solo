package hu.java.zalanmartinak;

import java.util.List;

/**
 * Created by MZ on 2016.04.07..
 */
public interface Display {

    public void showalert(String uzenet);
    public void showTable(List<Integer> cardNumbers, int place, List<String>names);
    public void showCards(List<Card> cards);
    public int chooseCard(List<Integer> selectable);
    public void showTopCard(Card card);
    public Colour chooseColour();
    public String getName();
}
