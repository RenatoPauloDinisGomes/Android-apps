package com.gomes.renato.mygym;

import java.util.List;

/**
 * Created by Renato on 13/08/2016.
 */
public class Workout {

    private List<Muscle> muscle;
    private int timeWorkingOut, day, month, year;
    private String typeWorkout;

    public Workout(List<Muscle> muscle, int timeWorkingOut, int day, int month, int year, String typeWorkout) {
        this.muscle = muscle;
        this.timeWorkingOut = timeWorkingOut;
        this.day = day;
        this.month = month;
        this.year = year;
        this.typeWorkout = typeWorkout;
    }
}
