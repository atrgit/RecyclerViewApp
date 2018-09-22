package com.example.profesor.recyclerviewapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorLibro extends RecyclerView.Adapter<AdaptadorLibro.LibroViewHolder>
        implements View.OnClickListener {
    private List<Libro>          listaLibros;
    private View.OnClickListener listener;

    public AdaptadorLibro(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @Override
    public LibroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // Crea la vista sin personalizar
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.renglon_lista_libros, parent, false);
        itemView.setOnClickListener(this);

        return new LibroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LibroViewHolder holder, int position) { // Personalizamos el ViewHolder
        holder.titulo.setText(listaLibros.get(position).getTitulo());
        holder.autor.setText(listaLibros.get(position).getAutor());
    }

    @Override
    public int getItemCount() { // Indicamos el número de elementos en la lista
        return listaLibros.size();
    }

    public void setOnclickListener( View.OnClickListener listener ) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if( listener != null) {
            listener.onClick(v);
        }
    }

    public class LibroViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo;
        public TextView autor;

        public LibroViewHolder(View view) {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            autor = (TextView) view.findViewById(R.id.autor);
        }
    }
}
