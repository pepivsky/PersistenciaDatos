package mx.pepivsky.tareasemana4recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.pepivsky.tareasemana4recyclerview.Adapter.MascotaAdaptador;
import mx.pepivsky.tareasemana4recyclerview.model.Mascota;

public class DetalleMascota extends AppCompatActivity {
ImageView imgRaiting;
    ArrayList mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        imgRaiting=((ImageView)findViewById(R.id.imgRaiting));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mascotas = new ArrayList<Mascota>();
        //llenado de la lista

        mascotas.add(new Mascota(R.drawable.aves_exoticas_del_amazonas_y_del_mundo,"Juancho", 7));
        mascotas.add(new Mascota(R.drawable.perro_carlino_485x300,"Firulais",5));
        mascotas.add(new Mascota(R.drawable.descarga,"Manchas", 2));
        mascotas.add(new Mascota(R.drawable.oveja,"Dolly", 6));
        mascotas.add(new Mascota(R.drawable.images,"Ernestin", 1));


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvRanking);



        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        recyclerView.setAdapter(adaptador);


    }


}
