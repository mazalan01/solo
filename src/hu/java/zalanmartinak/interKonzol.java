package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MZ on 2016.04.07..
 */
public class interKonzol implements Display {
    private List<Card> cards = new ArrayList<Card>();


    @Override
    public void showalert(String uzenet) {
        System.out.println(uzenet);
    }
    public List<String>names=new ArrayList<>();
    int i;
    @Override
    public void showTable(List<Integer> cardNumbers, int place, List<String> names) {
        this.names=names;
        i=place;
        //System.out.println(names.get(i));
        System.out.println("Cards in other players hand:");
        for(int i=0;i<cardNumbers.size()-1;i++)
        {
            int nowPalce=(i+1+place)%cardNumbers.size();
            System.out.print(names.get(nowPalce)+": "+cardNumbers.get(nowPalce));
            if (i != cardNumbers.size()-2) System.out.println(",");
        }
        System.out.println("");
    }

    @Override
    public void showCards(List<Card> cards) {
        //System.out.println(names.get(i));
        this.cards = cards;
        System.out.println("Your Cards:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(i + 1 + ". ");
            if (cards.get(i).getNumber() != Number.colourchange) System.out.print(cards.get(i).getColour());
            System.out.println(" " + cards.get(i).getNumber());
        }
    }

    @Override
    public int chooseCard(List<Integer> selectable) {
        //System.out.println(names.get(i));
        System.out.println("Choose a card from:");
        for (Integer aSelectable : selectable) System.out.println(aSelectable+1);
        int choosedNumber = 0;
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        choosedNumber = reader.nextInt();
        return choosedNumber-1;
    }

    @Override
    public void showTopCard(Card card) {
        //System.out.println(names.get(i));
        System.out.println("The card at the top of the throw deck:");
        System.out.println(card.getColour() + " " + card.getNumber());
    }

    @Override
    public Colour chooseColour() {
        System.out.println("Choose colour:");
        System.out.println("1. blue");
        System.out.println("2. green");
        System.out.println("3. red");
        System.out.println("4. yellow");
        int a;
        do
        {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            a = reader.nextInt();
        }while(a<1 || a>4);
        switch (a)
        {
            case 1:return Colour.blue;
            case 2:return Colour.green;
            case 3:return Colour.red;
            case 4:return Colour.yellow;
        }
        return Colour.green;
    }

    @Override
    public String getName() {
//        System.out.println(names.get(i));
        System.out.println("What's your name?:");
        return new Scanner(System.in).nextLine();
    }
}
