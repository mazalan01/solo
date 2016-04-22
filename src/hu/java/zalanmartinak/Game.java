package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MZ on 2016.04.08..
 */
public class Game {
    private boolean skipPlayer=false;
    private List<Player> players=new ArrayList<Player>();
    private Player currentPlayer;
    private Player getNextPlayer(){
        int cPlayer=players.indexOf(currentPlayer);
        cPlayer++;
        return players.get(cPlayer%players.size());
    }
    private Table table=new Table();
    Game (List<Display> players)
    {
        for (Display p:players
             ) {
            this.players.add(new Player(p));
        }
        for (Player p:this.players
             ) {
            p.name=p.inter.getName();
            for(int i=0;i<7;i++)p.deck.add(table.draw());
        }
        currentPlayer=this.players.get(0);
    }
    public void nextPlayer()
    {
        currentPlayer=getNextPlayer();
    }
    public boolean checkWin()
    {
        boolean b=currentPlayer.deck.size()==0;
        if (b) {
            for (Player p:players
                 ) {
                    p.inter.showalert(currentPlayer.name+" won!");
            }
        }
        return b;
    }
    public void step()
    {
        if(skipPlayer)
        {
            currentPlayer.inter.showalert("You skipped.");
            skipPlayer=false;
            return ;
        }
        //Show chards
        List<Integer> cardNumbers=new ArrayList<Integer>();
        List<String> names=new ArrayList<>();
        for (Player p:players
             ) {
            cardNumbers.add(p.deck.size());
            names.add(p.name);
        }
        for (Player p:players
             ) {
            p.inter.showTable(cardNumbers,players.indexOf(p),names);
            p.inter.showTopCard(table.getLastCard());
            p.inter.showCards(p.deck);
        }
        List<Integer> selectable=new ArrayList<Integer>();
        selectable.add(-1);
        for (Card c:currentPlayer.deck
             ) {
            if(table.getLastCard().getColour()==c.getColour() || table.getLastCard().getNumber()==c.getNumber() || c.getNumber()==Number.colourchange)selectable.add(currentPlayer.deck.indexOf(c));
        }
        //kovetkezo 2 current.
        currentPlayer.inter.showTopCard(table.getLastCard());
        currentPlayer.inter.showCards(currentPlayer.deck);
        int choosenCard;
        do{
            choosenCard = currentPlayer.inter.chooseCard(selectable);
        }while(!selectable.contains(choosenCard));
        if(choosenCard==-1)
        {
            currentPlayer.deck.add(table.draw());
        }
        else
        {
            table.throwCard(currentPlayer.deck.get(choosenCard));
            currentPlayer.deck.remove(choosenCard);
            if(table.getLastCard().getNumber()==Number.colourchange)
            {
                table.setLastCard(new Card(currentPlayer.inter.chooseColour(),Number.colourchange));
            }
            else if(table.getLastCard().getNumber()==Number.miss)
            {
                skipPlayer=true;
            }
            else if(table.getLastCard().getNumber()==Number.drawtwo)
            {
                getNextPlayer().deck.add(table.draw());
                getNextPlayer().deck.add(table.draw());
                skipPlayer=true;
            }
        }
    }

}
