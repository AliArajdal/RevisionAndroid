package com.ali.revision.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    private String nom;
    private String email;
    private String password;

    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }
    public User(Cursor c) {
        this.id = c.getInt(0);
        this.nom = c.getString(1);
        this.email = c.getString(2);
        this.password = c.getString(3);
    }

    protected User(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(email);
        dest.writeString(password);
    }
}
