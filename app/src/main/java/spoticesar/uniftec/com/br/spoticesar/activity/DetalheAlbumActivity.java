package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.task.SearchAlbumByIdTask;

public class DetalheAlbumActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener, SearchAlbumByIdTask.SearchAlbumByIdTaskDelegate {

    public static final String ALBUM_PARAM = "ALBUM_PARAM";

    // ======================

    private ListView musicasDoAlbumListView;

    private TextView txtvNomeAlbum;
    private TextView txtvNomeArtista;
    private TextView txtvDuracaoAlbum;
    private TextView txtvNumeroFans;
    private TextView txtvNumeroMusicas;

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

        SearchAlbumByIdTask task = new SearchAlbumByIdTask(this);

        task.execute(album.getId().toString());

    }

    private void atribuiElementosDeTela() {

        this.txtvNomeAlbum = findViewById(R.id.txtv_album_nome_album_imp);
        this.txtvNomeArtista = findViewById(R.id.txtv_album_nome_artista_imp);
        this.txtvDuracaoAlbum = findViewById(R.id.txtv_album_duracao_album_imp);
        this.txtvNumeroFans = findViewById(R.id.txtv_album_numero_fans_imp);
        this.txtvNumeroMusicas = findViewById(R.id.txtv_album_numero_musicas_imp);

        this.imgvCapaAlbum = this.findViewById(R.id.album_image_src);

        this.musicasDoAlbumListView = findViewById(R.id.musica_album_listView);
        this.musicasDoAlbumListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetalheMusicaActivity.class);
        intent.putExtra(DetalheMusicaActivity.MUSICA_PARAM, this.musicas.get(position));
        startActivity(intent);
    }

    @Override
    public void onSearchMovieSuccess(Album album) {

        this.txtvNomeAlbum.setText(album.getNome());
        this.txtvNomeArtista.setText(album.getArtista().getNome());

        this.txtvDuracaoAlbum.setText("" + album.getDuracao());
        this.txtvNumeroFans.setText("" + album.getNumeroFans());
        this.txtvNumeroMusicas.setText("" + album.getNumeroMusicas());

        this.populaMusicasDoAlbum(album.getMusicaResponse().getData());

        Picasso.with(this)
                .load(album.getImageUrl())
                .into(this.imgvCapaAlbum);

    }

    private void populaMusicasDoAlbum(List<Musica> musicas) {

        this.musicas = musicas;

        List<String> nomesMusicas = new ArrayList<>();

        for (Musica m : musicas)
            nomesMusicas.add(m.getNome());

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, nomesMusicas);

        this.musicasDoAlbumListView
                .setAdapter(arrayAdapter);

    }

    @Override
    public void onSearchMovieError(String error) {

    }

}
