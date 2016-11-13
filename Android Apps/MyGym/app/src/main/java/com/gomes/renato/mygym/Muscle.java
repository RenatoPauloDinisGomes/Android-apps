package com.gomes.renato.mygym;

/**
 * Created by Renato on 13/08/2016.
 */
public class Muscle {
    private String name;
    private int img;

    public Muscle(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
