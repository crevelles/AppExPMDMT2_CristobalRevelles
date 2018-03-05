package com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON;

import com.example.a21657540.appexpmdmt2_cristobalrevelles.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 21657540 on 05/03/2018.
 */

public class Country {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("flag")
    @Expose
    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /*
    -	Se deberá añadir un método a la clase Country, getFlagId() que reciba como parámetro
        el valor del campo flag y retorne un entero que represente el id del drawable correspondiente,
        almacenado en dicha carpeta.
     */

    public int getFlagId(String flag){
        int numero = 0;
        if(flag.equals("australia.png")) {
            numero = R.drawable.australia;
        } else if(flag.equals("denmark.png")){
            numero = R.drawable.denmark;
        } else if(flag.equals("italy.png")){
            numero = R.drawable.italy;
        } else if(flag.equals("spain.png")){
            numero = R.drawable.spain;
        } else if(flag.equals("uk.png")){
            numero = R.drawable.uk;
        } else if(flag.equals("usa.png")){
            numero = R.drawable.usa;
        }

        return numero;
    }

}
