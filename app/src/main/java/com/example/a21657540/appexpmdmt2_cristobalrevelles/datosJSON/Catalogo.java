package com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 21657540 on 05/03/2018.
 */

public class Catalogo {

    @SerializedName("cds")
    @Expose
    private List<Cd> cds = null;
    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;

    public List<Cd> getCds() {
        return cds;
    }

    public void setCds(List<Cd> cds) {
        this.cds = cds;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
