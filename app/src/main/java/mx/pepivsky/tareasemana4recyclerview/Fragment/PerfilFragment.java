package mx.pepivsky.tareasemana4recyclerview.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.pepivsky.tareasemana4recyclerview.Adapter.MascotaAdaptador;
import mx.pepivsky.tareasemana4recyclerview.model.Mascota;
import mx.pepivsky.tareasemana4recyclerview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private ArrayList<Mascota> mascotaperfil;
    private RecyclerView listaMascotasperfil;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotasperfil = (RecyclerView)v.findViewById(R.id.rvPerfil);
        GridLayoutManager llm =new GridLayoutManager(getContext(),3);
        listaMascotasperfil.setLayoutManager(llm);
        InicializarListaMascotas();
        inicializarAdpatador();
        return v;
    }

    public void InicializarListaMascotas(){ //Método que inicializa la  lista
        mascotaperfil = new ArrayList<Mascota>();
        //llenado de la lista

        mascotaperfil.add(new Mascota(R.drawable.guacamayo,"Juancho", 2));
        mascotaperfil.add(new Mascota(R.drawable.guacamayo_rojo,"Juancho", 5));
        mascotaperfil.add(new Mascota(R.drawable.guacamayo2,"Juancho", 2));

    }

    public void inicializarAdpatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotaperfil,getActivity());
        listaMascotasperfil.setAdapter(adaptador);
    }
}
