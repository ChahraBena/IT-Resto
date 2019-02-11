package com.demotxt.myapp.recyclerview;

import android.provider.ContactsContract;

/**
 * Created by Aws on 28/01/2018.
 */

public class Resto {



    private String Title;
    private String Category ;
    private String Description ;
    private int Thumbnail ;
    private String Facebook;
    private String Num;
    private String Mail;
    private String Twitter;
    private String Adresse;

    public Resto(String title, String category, String description, int thumbnail, String facebook, String num, String mail, String twitter, String adresse) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Facebook = facebook;
        Num = num;
        Mail = mail;
        Twitter = twitter;
        Adresse = adresse;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }
}
