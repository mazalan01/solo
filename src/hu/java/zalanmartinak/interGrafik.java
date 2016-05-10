package hu.java.zalanmartinak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//

/**
 * Created by MZ on 2016.04.09..
 */
public class interGrafik implements Display {
    private volatile HashMap<Card,JButton> cardButtons=new HashMap<>();
    /* interGrafik()
    {
        gra.main();
    }*/
    List<Card> ownCards=new ArrayList<>();
    @Override
    public void showalert(String uzenet) {
        JOptionPane.showMessageDialog(thisWindow,uzenet);
    }

    @Override
    public void showTable(List<Integer> cardNumbers, int place, List<String> names) {
        String a1="";
        String a2="";
        for(int i=0;i<cardNumbers.size();i++)
        {
            if(i<place)
            {
                a1+=names.get(i)+": "+cardNumbers.get(i)+", ";
            }
            else if(i>place)
            {
                a2+=names.get(i)+": "+cardNumbers.get(i)+", ";
            }
        }
        a2+=a1;
        thisWindow.setTable(a2);
    }

    JButton but;

    @Override
    public void showCards(List<Card> cards) {
        ownCards=cards;
        HashMap<Card,JButton> cardButtonCopy= (HashMap<Card, JButton>) cardButtons.clone();
        for (Card c:cardButtonCopy.keySet()
             ) {
            if(!cards.contains(c)){
                thisWindow.getOwnCards().remove(cardButtons.get(c));
                cardButtons.remove(c);
            }
        }
        for (Card c:cards
             ) {
            if(!cardButtons.containsKey(c))
            {
                JButton b=new JButton();
                b.setText(c.getColour()+" "+c.getNumber());
                b.setEnabled(false);

                b.addActionListener(e -> {
                    but= (JButton) e.getSource();
                    synchronized (cardButtons){

                            cardButtons.notify();
                        }
                });
                thisWindow.getOwnCards().add(b);
                cardButtons.put(c,b);
                thisWindow.repaint();
            }
        }
    }

    @Override
    public int chooseCard(List<Integer> selectable) {

        for (Integer i:selectable
             ) {
            if(i!=-1) {
                cardButtons.get(ownCards.get(i)).setEnabled(true);
            }
        }

        synchronized (cardButtons){
        try {
            cardButtons.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
        for (Integer i:selectable
                ) {
            if(i!=-1) {
                cardButtons.get(ownCards.get(i)).setEnabled(false);
            }
        }
        for (Card c:cardButtons.keySet()
             ) {
            if(cardButtons.get(c)==but)return ownCards.indexOf(c);
        }
        return -1;
    }

    @Override
    public void showTopCard(Card card) {
        thisWindow.setTopCard(card.getColour()+ " " +card.getNumber());
    }

    @Override
    public Colour chooseColour() {
        //int choice = TaskDialogs.radioChoice("You've got selection to make", "Go ahead", 1, "Yes", "No", "May be" );
        Object[] possibilities = {"green", "blue", "yellow", "red"};
        String s = (String)JOptionPane.showInputDialog(
                new Frame(),
                "Choose a colour:\n","",
                JOptionPane.PLAIN_MESSAGE, null,
                possibilities,
                "green");

//If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
           // setLabel("Green eggs and... " + s + "!");
            if(s=="red")return Colour.red;
            else if(s=="blue") return Colour.blue;
            else if(s=="yellow") return Colour.yellow;

        }
        return Colour.green;
//If you're here, the return value was null/empty.
       //setLabel("Come on, finish the sentence!");
        //return null;4
    }


    NameDialog name=new NameDialog();
    GraphicWindow thisWindow=new GraphicWindow();

    @Override
    public String getName() {
        name.pack();
        name.setVisible(true);
        String a=name.getPlayerName();
        new Thread()
        {
            @Override
            public void run()
            {
                thisWindow.pack();
                thisWindow.setVisible(true);
            }
        }.start();
        thisWindow.getDrawButton().addActionListener(e -> {
            but= (JButton) e.getSource();
            synchronized (cardButtons){

                cardButtons.notify();
            }
        });
        thisWindow.getDrawButton().setPreferredSize(new Dimension(100,100));
        thisWindow.getDrawButton().setSize(100,100);
       // thisWindow.setResizable(false);
        name.setModal(false);
        return a;
    }
}

