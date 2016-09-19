package mx.pepivsky.tareasemana4recyclerview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import mx.pepivsky.tareasemana4recyclerview.Adapter.PageAdapter;
import mx.pepivsky.tareasemana4recyclerview.Fragment.PerfilFragment;
import mx.pepivsky.tareasemana4recyclerview.Fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {
//Hola
    private static final String KEY_EXTRA_NAME = "name";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout =(TabLayout)findViewById(R.id.tabLaoyout);
        viewPager =(ViewPager)findViewById(R.id.viewPager);
        Log.e("MainActivity", "onCreate");
        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,mcontacto.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent i = new Intent(this,mabout.class);
                startActivity(i);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        Log.e("MainActivity", "agregarFragments");
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());


        return fragments;
    }


    public void irDetalle(View v){
        Intent intent= new Intent(this,DetalleMascota.class);
        startActivity(intent);

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Agregar icono a las Tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_dog);

        //Agregar un texto en las tabs
        //tabLayout.getTabAt(2).setText(R.string.email);


    }

}
