package com.example.a21657540.appexpmdmt2_cristobalrevelles;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Cd;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.recyclerViewUtils.Adaptador;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.retrofitUtils.RestService;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Cd> listaCd;
    private RecyclerView rv;
    private LinearLayoutManager lm;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCd = new ArrayList<Cd>();
        invocarWS();
    }


    private void invocarWS() {
        if(isNetworkAvailable()){
            Retrofit r = RetrofitClient.getClient(RestService.BASE_URL);
            RestService rp = r.create(RestService.class);
            Call<ArrayList<Cd>> call = rp.mostrarLista();

            call.enqueue(new Callback<ArrayList<Cd>>() {

                @Override
                public void onResponse(Call<ArrayList<Cd>> call, Response<ArrayList<Cd>> response) {
                    if(!response.isSuccessful()){
                        //ERRROR
                    } else {
                        ArrayList<Cd> cds = response.body();
                        for (Cd cd : cds) {
                            listaCd.add(cd);
                        }
                        configurarRV();
                    }

                }

                @Override
                public void onFailure(Call<ArrayList<Cd>> call, Throwable t) {

                }
            });

        }
    }

    private void configurarRV() {
        rv = findViewById(R.id.idRV);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adaptador = new Adaptador(listaCd);
        rv.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cd cd = listaCd.get(rv.getChildAdapterPosition(v));
                Intent i = new Intent(MainActivity.this, DatosCDActivity.class);
                i.putExtra("titulo", cd.getTitle());
                startActivity(i);

            }
        });
    }

    private boolean isNetworkAvailable() {
        boolean isAvailable = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return  isAvailable;
    }



}
