package com.ali.revision.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Personne implements Parcelable {
    private int id;
    private int image;
    private String name;
    private String email;

    public Personne(int id, int image, String name, String email) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.email = email;
    }

    protected Personne(Parcel in) {
        id = in.readInt();
        image = in.readInt();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(email);
    }
}
