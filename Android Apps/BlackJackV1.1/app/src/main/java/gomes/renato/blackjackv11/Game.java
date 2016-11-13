package gomes.renato.blackjackv11;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

public class Game {


    private ArrayList<Card> Deck;
    private int top;

    public Game(Context con) {
        this.Deck = new ArrayList<Card>();
        top = 0;
        int i = 0;
        String[] Names = {"aceofclubs", "aceofdiamonds", "aceofhearts", "aceofspades", "blackjoker", "eightofclubs", "eightofdiamonds", "eightofhearts", "eightofspades", "fiveofclubs", "fiveofdiamonds", "fiveofhearts", "fiveofspades", "fourofclubs", "fourofdiamonds", "fourofhearts", "fourofspades", "jackofclubs", "jackofdiamonds", "jackofhearts", "jackofspades", "kingofclubs", "kingofdiamonds", "kingofhearts", "kingofspades", "nineofclubs", "nineofdiamonds", "nineofhearts", "nineofspades", "queenofclubs", "queenofdiamonds", "queenofhearts", "queenofspades", "redjoker", "sevenofclubs", "sevenofdiamonds", "sevenofhearts", "sevenofspades", "sixofclubs", "sixofdiamonds", "sixofhearts", "sixofspades", "tenofclubs", "tenofdiamonds", "tenofhearts", "tenofspades", "treeofclubs", "treeofdiamonds", "treeofhearts", "treeofspades", "twoofclubs", "twoofdiamonds", "twoofhearts", "twoofspades"};
        for (i = 0; i < Names.length; i++) {
            // Card card = new Card(Names[i], 3);
            if (Names[i].startsWith("ace")) {
                Card card = new Card(Names[i], 11);

                Deck.add(card);
            } else if (Names[i].startsWith("eight")) {
                Card card = new Card(Names[i], 8);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("nine")) {
                Card card = new Card(Names[i], 9);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("seven")) {
                Card card = new Card(Names[i], 7);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("six")) {
                Card card = new Card(Names[i], 6);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("five")) {
                Card card = new Card(Names[i], 5);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("four")) {
                Card card = new Card(Names[i], 4);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("king") || Names[i].startsWith("queen") || Names[i].startsWith("jack") || Names[i].startsWith("ten")) {
                Card card = new Card(Names[i], 10);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("tree")) {
                Card card = new Card(Names[i], 3);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else if (Names[i].startsWith("two")) {
                Card card = new Card(Names[i], 2);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            } else {
                Card card = new Card(Names[i], 1000);
                card.setResId(con.getResources().getIdentifier(card.getId(), "drawable",con.getPackageName()));
                Deck.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return Deck;
    }


    public void plusTop()
    {
        this.top++;
    }
    public void setTop(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void Shuffle() {
        Collections.shuffle(Deck);
        top = 0;
    }

    public void setDeck(ArrayList<Card> deck) {
        Deck = deck;
    }
}
