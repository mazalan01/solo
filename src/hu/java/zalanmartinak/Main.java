package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MZ on 2016.04.07..
 */
public class Main {
    private static List<Card> colours=new ArrayList<Card>();
    private static void setColours(List<Card>a)
    {
        {
            Card colourCard = new Card(Colour.blue, Number.colourchange);
            a.add(colourCard);
        }
        {
            Card colourCard = new Card(Colour.green, Number.colourchange);
            a.add(colourCard);
        }
        {
            Card colourCard = new Card(Colour.red, Number.colourchange);
            a.add(colourCard);
        }
        {
            Card colourCard = new Card(Colour.yellow, Number.colourchange);
            a.add(colourCard);
        }
    }
    public static void main(String[] args){
        List<Display> players=new ArrayList<Display>();
        players.add(new interKonzol());
        players.add(new interAI());
        players.add(new interAI2());
        Game game=new Game(players);
        boolean win=false;
        while(!win)
        {
            game.step();
            win=game.checkWin();
            game.nextPlayer();
        }
        System.out.println("Someone won!");
        /*setColours(colours);
        Table table=new Table();
        List<Player> players=new ArrayList<Player>();
        int playerAmount=2;
        //makePlayers(playerAmount,players,table);
        int nextPlayer=playerAmount-1;
        while(players.get(nextPlayer).deck.size()!=0)
        {
            nextPlayer++;
            nextPlayer=nextPlayer%playerAmount;
            players.get(nextPlayer).inter.showalert("The next player: "+players.get(nextPlayer).name);
            List<Integer> showTable=new ArrayList<Integer>();
            for(int i=0;i<playerAmount-1;i++){showTable.add(players.get((nextPlayer+i+1)%playerAmount).deck.size());}
            System.out.println("v:"+showTable.get(0));
            players.get(nextPlayer).inter.showTable(showTable);
            players.get(nextPlayer).inter.showCards(players.get(nextPlayer).deck);
            players.get(nextPlayer).inter.showTopCard(table.getLastCard());
            int number=0;
            do {
                number=players.get(nextPlayer).inter.chooseCard();
            }while(number<0 || number>players.get(nextPlayer).deck.size() || good(players.get(nextPlayer),number,table));
            if(number==0){
                players.get(nextPlayer).deck.add(table.draw());
                players.get(nextPlayer).inter.showCards(players.get(nextPlayer).deck);
            }
            else
            {
                table.throwCard(players.get(nextPlayer).deck.get(number-1));
                for(int i=number;i<players.get(nextPlayer).deck.size();i++) {
                    players.get(nextPlayer).deck.set(i - 1,players.get(nextPlayer).deck.get(i));
                }
                players.get(nextPlayer).deck.remove(players.get(nextPlayer).deck.size() - 1);
                if(table.getLastCard().getNumber()==Number.miss)nextPlayer++;
                else if(table.getLastCard().getNumber()==Number.drawtwo)
                {
                    nextPlayer++;
                    nextPlayer=nextPlayer%playerAmount;
                    players.get(nextPlayer).deck.add(table.draw());
                    players.get(nextPlayer).deck.add(table.draw());
                    players.get(nextPlayer).inter.showCards(players.get(nextPlayer).deck);
                }
                else if(table.getLastCard().getNumber()==Number.colourchange)
                {
                    int num=0;
                    players.get(nextPlayer).inter.showCards(colours);
                    do
                    {
                        System.out.println(num);
                        num=players.get(nextPlayer).inter.chooseCard();
                    }while(num>4 || num<1);
                    players.get(nextPlayer).inter.showCards(players.get(nextPlayer).deck);
                    table.setLastCard(colours.get(num));
                }
            }
        }
        for(int i=0;i<playerAmount;i++)players.get(i).inter.showalert(""+ players.get(nextPlayer+1) + " player won!");
    }
    private static boolean good(Player player,int number,Table table)
    {
        if(number==0)return false;
        else if(table.getLastCard().canPutCard(player.deck.get(number-1)))return false;
        else if(player.deck.get(number-1).getNumber()==Number.colourchange)return false;
        return true;
    }
    /*private static void makePlayers(int playerAmount,List<Player>players,Table table)
    {
        for(int i=0;i<playerAmount;i++)
        {
            Player player=new Player();
            for(int j=0;j<7;j++){
                player.deck.add(table.draw());
            }
            players.add(player);
        }
        for(int i=0;i<playerAmount;i++)
        {
            players.get(i).inter=new interKonzol();
            players.get(i).name=players.get(i).inter.getName();
        }
    */}
}
