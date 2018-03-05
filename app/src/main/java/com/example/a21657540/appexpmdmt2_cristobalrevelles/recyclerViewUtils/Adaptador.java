package com.example.a21657540.appexpmdmt2_cristobalrevelles.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a21657540.appexpmdmt2_cristobalrevelles.R;
import com.example.a21657540.appexpmdmt2_cristobalrevelles.datosJSON.Cd;

import java.util.ArrayList;

/**
 * Created by 21657540 on 05/03/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.VHcd> implements View.OnClickListener {


    private ArrayList<Cd> listado;
    private View.OnClickListener listener;


    public Adaptador(ArrayList<Cd> listado) {
        this.listado = listado;
    }

    @Override
    public Adaptador.VHcd onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cd, parent, false);
        view.setOnClickListener(this);
        VHcd vhp = new VHcd(view);
        return vhp;
    }

    @Override
    public void onBindViewHolder(Adaptador.VHcd holder, int position) {
        //holder.tvTitulo.setText(peliculas.get(position).getNombre());
        holder.tvCD.setText(listado.get(position).getTitle());
        holder.tvGrupo.setText(listado.get(position).getArtist());

    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public static class VHcd extends RecyclerView.ViewHolder{

        private TextView tvCD, tvGrupo;

        public VHcd(View itemView) {
            super(itemView);
           tvCD = itemView.findViewById(R.id.idTituloCD);
           tvGrupo = itemView.findViewById(R.id.idArtista);
        }

        public TextView getTvCD() {
            return tvCD;
        }

        public void setTvCD(TextView tvCD) {
            this.tvCD = tvCD;
        }

        public TextView getTvGrupo() {
            return tvGrupo;
        }

        public void setTvGrupo(TextView tvGrupo) {
            this.tvGrupo = tvGrupo;
        }
    }


}
