package com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 21657540 on 05/03/2018.
 */

public class Cd {



    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("year")
    @Expose
    private String year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
