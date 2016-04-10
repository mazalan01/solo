package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by MZ on 2016.04.10..
 */
public class interAI implements Display{
    private List<Card> cards=new ArrayList<>();
    @Override
    public void showalert(String uzenet) {

    }

    @Override
    public void showTable(List<Integer> cardNumbers, int place, List<String> names) {

    }

    @Override
    public void showCards(List<Card> cards) {
        this.cards=cards;
    }

    @Override
    public int chooseCard(List<Integer> selectable) {
        if(selectable.size()!=1)
        {
            Random rand = new Random();
            int  b = rand.nextInt(selectable.size()-1) + 1;
            int n=selectable.get(b);
            System.out.println("AI put: "+cards.get(n).getColour()+" "+cards.get(n).getNumber());
            return n;
        }
        System.out.println("AI draw");
        return -1;
    }

    @Override
    public void showTopCard(Card card) {

    }

    @Override
    public Colour chooseColour() {
        Random rand = new Random();
        int  n = rand.nextInt(4) + 1;
        switch (n)
        {
            case 1:System.out.println("AI choosed colour:green");return Colour.green;
            case 2:System.out.println("AI choosed colour:blue");return Colour.blue;
            case 3:System.out.println("AI choosed colour:red");return Colour.red;
            case 4:System.out.println("AI choosed colour:yellow");return Colour.yellow;
        }
        return null;
    }

    @Override
    public String getName() {
        return "AI";
    }
}
