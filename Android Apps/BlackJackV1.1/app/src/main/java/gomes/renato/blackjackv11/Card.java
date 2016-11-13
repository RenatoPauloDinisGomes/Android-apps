package gomes.renato.blackjackv11;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Card {
    private String id;
    private int points;
    private int resId;

    public Card(String id, int points) {
        this.id = id;
        this.points = points;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
