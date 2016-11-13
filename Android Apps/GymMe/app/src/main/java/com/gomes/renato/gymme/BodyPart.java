package com.gomes.renato.gymme;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Renato on 11/08/2016.
 */
public class BodyPart implements Parcelable {
    private String PartName;
    private int img;
    private String subPartName;

    protected BodyPart(Parcel in) {
        PartName = in.readString();
        img = in.readInt();
        subPartName = in.readString();
    }

    public static final Creator<BodyPart> CREATOR = new Creator<BodyPart>() {
        @Override
        public BodyPart createFromParcel(Parcel in) {
            return new BodyPart(in);
        }

        @Override
        public BodyPart[] newArray(int size) {
            return new BodyPart[size];
        }
    };

    public String getSubPartName() {
        return subPartName;
    }

    public void setSubPartName(String subPartName) {
        this.subPartName = subPartName;
    }

    public BodyPart(String partName, int img, String subPartName) {
        PartName = partName;
        this.img = img;
        this.subPartName = subPartName;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        this.PartName = partName;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(PartName);
        parcel.writeInt(img);
        parcel.writeString(subPartName);
    }
}
