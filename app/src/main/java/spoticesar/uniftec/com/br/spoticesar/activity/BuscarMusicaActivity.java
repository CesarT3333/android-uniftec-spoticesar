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
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class BuscarMusicaActivity
        extends AppCompatActivity {

    private List<Musica> musicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_musica);

        RecyclerView listaAlbunsRecyclerView =
                this.findViewById(R.id.musica_recycler_view);

        this.musicas = Mock.mockMusicas;

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        ImageRecyclerViewAdapter imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Musica>(
                        this,
                        this.musicas,
                        DetalheMusicaActivity.MUSICA_PARAM,
                        DetalheMusicaActivity.class
                );

        listaAlbunsRecyclerView.setLayoutManager(layoutManager);
        listaAlbunsRecyclerView.setAdapter(imageRecyclerViewAdapter);

    }

}
