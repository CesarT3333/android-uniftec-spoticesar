package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageListViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;

public class BuscarArtistaActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private List<Artista> artistas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_artista);

        List<GenericEntity> albuns = new ArrayList<>();

        this.artistas = Mock.mockArtistas;
        albuns.addAll(this.artistas);

        ImageListViewAdapter imageListViewAdapter =
                new ImageListViewAdapter(BuscarArtistaActivity.this, albuns);

        ListView artistaListView = this.findViewById(R.id.artista_list_view);

        artistaListView.setAdapter(imageListViewAdapter);
        artistaListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, DetalheArtistaActivity.class);

        intent.putExtra(DetalheArtistaActivity.ARTISTA_PARAM,
                this.artistas.get(position));

        startActivity(intent);

    }

}
