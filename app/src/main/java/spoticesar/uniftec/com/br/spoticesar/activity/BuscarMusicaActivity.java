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
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class BuscarMusicaActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private List<Musica> musicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_musica);

        List<GenericEntity> albuns = new ArrayList<>();

        this.musicas = Mock.mockMusicas;

        albuns.addAll(this.musicas);

        ImageListViewAdapter imageListViewAdapter =
                new ImageListViewAdapter(BuscarMusicaActivity.this, albuns);

        ListView musicaListView = this.findViewById(R.id.musica_list_view);

        musicaListView.setOnItemClickListener(this);

        musicaListView.setAdapter(imageListViewAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, DetalheMusicaActivity.class);

        Musica m = this.musicas.get(position);

        intent.putExtra(DetalheMusicaActivity.MUSICA_PARAM, m);

        startActivity(intent);

    }

}
