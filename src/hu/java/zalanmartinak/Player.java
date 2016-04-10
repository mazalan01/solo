package hu.java.zalanmartinak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MZ on 2016.04.07..
 */
public class Player {
    Player (Display i)
    {
        inter=i;
    }
    public Display inter;
    public List<Card> deck=new ArrayList<Card>();
    public String name;
}
