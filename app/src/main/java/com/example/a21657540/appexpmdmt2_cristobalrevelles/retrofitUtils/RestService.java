package com.example.a21657540.appexpmdmt2_cristobalrevelles.retrofitUtils;

import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Cd;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Country;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 21657540 on 05/03/2018.
 */

public interface RestService {


    public static final String BASE_URL = "http://10.0.2.2:3000/";

    //http://10.0.2.2:3000/cds
    @GET("cds")
    Call<ArrayList<Cd>> mostrarLista();


    //http://10.0.2.2:3000/cds?title=tituloSeleccionado
    @GET("cds")
    Call<ArrayList<Cd>> mostrarCD(@Query("title") String titulo);

    //http://localhost:3000/countries/{id_country}
    @GET("countries/{id}")
    Call<ArrayList<Country>> mostrarPais(@Path("id") int id);



}
