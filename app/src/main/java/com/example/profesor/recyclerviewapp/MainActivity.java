package com.example.profesor.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Libro>    listaLibros = new ArrayList<>();
    private RecyclerView   recyclerView;
    private AdaptadorLibro mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recylcer_view);

        mAdapter = new AdaptadorLibro( listaLibros );
        mAdapter.setOnclickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int   posicion = recyclerView.getChildLayoutPosition( v );
                Libro libro    = listaLibros.get( posicion );
                Log.wtf("VISTAREC", Integer.toString(posicion));
                Log.wtf("VISTAREC", libro.getTitulo());
                Log.wtf("VISTAREC", libro.getAutor());
            }
        });

        // PASO 5
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager( mLayoutManager );

        recyclerView.setLayoutManager( new GridLayoutManager(this,3));

        recyclerView.setAdapter( mAdapter );

        inicializaDatosLibros();
    }

    private void inicializaDatosLibros() {
        Libro libro = new Libro("Programación con Android", "Big Nerd Ranch");
        listaLibros.add(libro);

        libro = new Libro("Desarrollo de aplicaciones para Android", "ANAYA MULTIMEDIA");
        listaLibros.add(libro);

        libro = new Libro("El gran libro de Android", "Jesús Tomás Gironés");
        listaLibros.add(libro);

        libro = new Libro("Android Tablet Development", "Wei Meng Lee");
        listaLibros.add(libro);

        libro = new Libro("Android Apps Security", "Sheran Gunasekera");
        listaLibros.add(libro);

        libro = new Libro("Learning Android Development", "Rajesh Pattanaik");
        listaLibros.add(libro);

        libro = new Libro("Learning Java by Building Android Games", "John Horton");
        listaLibros.add(libro);

        libro = new Libro("Android Programming: Pushing the Limits", "Sheran Gunasekera");
        listaLibros.add(libro);

        libro = new Libro("Android Apps Security", "Sheran Gunasekera");
        listaLibros.add(libro);

        libro = new Libro("Learning Android Development", "Rajesh Pattanaik");
        listaLibros.add(libro);

        libro = new Libro("Learning Java by Building Android Games", "John Horton");
        listaLibros.add(libro);

        libro = new Libro("Android Programming: Pushing the Limits", "Sheran Gunasekera");
        listaLibros.add(libro);

        mAdapter.notifyDataSetChanged();
    }
}
