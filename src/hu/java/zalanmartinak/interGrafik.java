package hu.java.zalanmartinak;

import java.util.List;

/**
 * Created by MZ on 2016.04.09..
 */
public class interGrafik implements Display {
    GraphicWindow gra=new GraphicWindow();
    interGrafik()
    {
        new Thread()
        {
            @Override
            public void run() {
                gra.main();
            }
        }.start();
    }
    @Override
    public void showalert(String uzenet) {

    }

    @Override
    public void showTable(List<Integer> cardNumbers, int place, List<String> names) {

    }

    @Override
    public void showCards(List<Card> cards) {

    }

    @Override
    public int chooseCard(List<Integer> selectable) {
        return 0;
    }

    @Override
    public void showTopCard(Card card) {

    }

    @Override
    public Colour chooseColour() {
        return null;
    }

    @Override
    public String getName() {
        return gra.getPlayerName();
    }
}
