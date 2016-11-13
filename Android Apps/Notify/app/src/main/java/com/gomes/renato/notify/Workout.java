package com.gomes.renato.notify;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Renato on 12/08/2016.
 */
public class Workout implements Parcelable {
    private BodyPart part;
    private int reps;
    private int weight;
    private int day, month, year;

    private String cmt;

    protected Workout(Parcel in) {
        part = in.readParcelable(BodyPart.class.getClassLoader());
        reps = in.readInt();
        weight = in.readInt();
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
        cmt = in.readString();
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getCmt() {
        return cmt;
    }

    public BodyPart getPart() {
        return part;
    }

    public void setPart(BodyPart part) {
        this.part = part;
    }


    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static Creator<Workout> getCREATOR() {
        return CREATOR;
    }

    public Workout(BodyPart part, int reps, int weight, String cmt) {
        this.cmt = cmt;
        this.part = part;
        this.reps = reps;
        this.weight = weight;
        Calendar startDate = Calendar.getInstance();
        this.day = startDate.get(Calendar.DAY_OF_MONTH);
        this.month = startDate.get(Calendar.MONTH)+1;
        this.year = startDate.get(Calendar.YEAR);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(part, i);
        parcel.writeInt(reps);
        parcel.writeInt(weight);
        parcel.writeString(cmt);
    }

    public void setDate(int a, int b, int c) {
        this.day = a;
        this.month = b;
        this.year = c;
    }
}
