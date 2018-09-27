package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.utils.MockFilter;

public class DetalheAlbumActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    public static final String ALBUM_PARAM = "ALBUM_PARAM";

    // ======================

    private ListView musicasDoAlbumListView;

    private TextView txtvNomeAlbum;
    private TextView txtvNomeArtista;
    private List<Musica> musicas;
    private ImageView imgvCapaAlbum;

    // ======================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);

        Intent intent = this.getIntent();

        Album album = (Album)
                intent.getSerializableExtra(ALBUM_PARAM);

        this.atribuiElementosDeTela();
        this.populaAlbumEmTela(album);

        this.populaMusicasDoAlbum(
                MockFilter.getMusicasDoAlbum(album.getId()));

    }

    private void atribuiElementosDeTela() {
        this.txtvNomeAlbum = findViewById(R.id.txtv_album_nome_album);
        this.txtvNomeArtista = findViewById(R.id.txtv_album_nome_artista);

        this.musicasDoAlbumListView = findViewById(R.id.musica_album_listView);
        this.musicasDoAlbumListView.setOnItemClickListener(this);

        this.imgvCapaAlbum = findViewById(R.id.album_image_src);
        this.imgvCapaAlbum.setImageResource(R.drawable.imagi);
    }

    // =======================

    private void populaMusicasDoAlbum(List<Musica> musicas) {

        List<String> musicasToString = this.getMusicNames(musicas);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, musicasToString);

        this.musicasDoAlbumListView
                .setAdapter(arrayAdapter);

    }

    private void populaAlbumEmTela(Album album) {
        this.txtvNomeAlbum.setText(album.getNome());
        this.txtvNomeArtista.setText(album.getArtista().getNome());
    }

    private List<String> getMusicNames(List<Musica> musicas) {

        List<String> nomesDasMusicas = new ArrayList<>();

        this.musicas = Mock.mockMusicas;

        for (Musica m : Mock.mockMusicas)
            nomesDasMusicas.add(m.getNome());

        return nomesDasMusicas;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetalheMusicaActivity.class);
        intent.putExtra(DetalheMusicaActivity.MUSICA_PARAM, this.musicas.get(position));
        startActivity(intent);
    }

}
