package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageListViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;

public class BuscarArtistaActivity
        extends AppCompatActivity {

    private List<Artista> artistas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_artista);

        RecyclerView listaAlbunsRecyclerView =
                this.findViewById(R.id.artista_recycler_view);

        this.artistas = Mock.mockArtistas;

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        ImageRecyclerViewAdapter imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Artista>(
                        this,
                        this.artistas,
                        DetalheArtistaActivity.ARTISTA_PARAM,
                        DetalheArtistaActivity.class
                );

        listaAlbunsRecyclerView.setLayoutManager(layoutManager);
        listaAlbunsRecyclerView.setAdapter(imageRecyclerViewAdapter);

    }

}
