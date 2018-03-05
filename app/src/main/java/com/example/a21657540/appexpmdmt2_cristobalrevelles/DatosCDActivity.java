package com.example.a21657540.appexpmdmt2_cristobalrevelles;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Cd;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Country;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.retrofitUtils.RestService;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DatosCDActivity extends AppCompatActivity {


    private String titulo;
    private TextView titu, artista, compania, ano, precio;
    private ImageView imagen;
    private ArrayList<Cd> listado;
    private Cd cd;
    private Country country;
    private ArrayList<Country> conutries;
    private ArrayList<Cd> misCd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cd);

        titulo = getIntent().getStringExtra("titulo");

        titu = findViewById(R.id.idTituloCD);
        artista = findViewById(R.id.idArtistaCD);
        compania = findViewById(R.id.idCompany);
        ano = findViewById(R.id.idAno);
        precio = findViewById(R.id.idPrecio);
        imagen = findViewById(R.id.idImagen);

        listado = new ArrayList<Cd>();
        conutries = new ArrayList<Country>();

        invocarWS();

    }


    private void invocarWS() {
        Retrofit r = RetrofitClient.getClient(RestService.BASE_URL);
        final RestService rp = r.create(RestService.class);
        Call<ArrayList<Cd>> call = rp.mostrarCD((titulo));
        call.enqueue(new Callback<ArrayList<Cd>>() {

            @Override
            public void onResponse(Call<ArrayList<Cd>> call, Response<ArrayList<Cd>> response) {
                misCd = response.body();
                titu.setText(misCd.get(0).getTitle());
                artista.setText(misCd.get(0).getArtist());
                compania.setText(getResources().getString(R.string.txtCompany)+ " "+misCd.get(0).getCompany());
                ano.setText(getResources().getString(R.string.txtYear)+ " "+misCd.get(0).getYear());
                precio.setText(getResources().getString(R.string.txtPrice)+ " "+misCd.get(0).getPrice());


                //mostrarImagen();

            }

            @Override
            public void onFailure(Call<ArrayList<Cd>> call, Throwable t) {

            }

        });

    }

    public void mostrarImagen(){
        Retrofit rt2 = RetrofitClient.getClient(RestService.BASE_URL);
        RestService rsp2 = rt2.create(RestService.class);

        Call<ArrayList<Country>> call = rsp2.mostrarPais(country.getFlagId(cd.getCountry()));

        call.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                if (!response.isSuccessful()) {
                    Log.e("error", toString());
                } else {
                    ArrayList<Country> clas = response.body();
                    int icono = conutries.get(0).getId();
                    Drawable drawable = getResources().getDrawable(icono);
                    imagen.setImageDrawable(drawable);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

            }
        });
    }

}
