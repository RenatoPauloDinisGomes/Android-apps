package com.gomes.renato.gymme;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Renato on 12/08/2016.
 */
public class Workout implements Parcelable{
    private BodyPart part;
    private int repetitions;
    private int weight;
    private Date date;
    private String cmt;

    protected Workout(Parcel in) {
        part = in.readParcelable(BodyPart.class.getClassLoader());
        repetitions = in.readInt();
        weight = in.readInt();
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


    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Workout(BodyPart part, int reps, int weight, String cmt) {
        this.cmt = cmt;
        this.part = part;
        this.repetitions = reps;
        this.weight = weight;
        this.date = new Date();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(part, i);
        parcel.writeInt(repetitions);
        parcel.writeInt(weight);
        parcel.writeString(cmt);
    }
}
