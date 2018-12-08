package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumListResponse;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.task.SearchAlbunsDoArtistaTask;

public class DetalheArtistaActivity
        extends AppCompatActivity
        implements SearchAlbunsDoArtistaTask.SearchArtistaByIdTaskDelegate {

    public static final String ARTISTA_PARAM = "ARTISTA_PARAM";

    // ==========================

    private TextView txtvNumeroAlbuns;
    private TextView txtvNomeArtista;
    private TextView txtvNumeroFans;

    private ListView listViewAlbuns;
    private ImageView imgvArtista;

    // ==========================

    private List<Artista> artistas;
    private List<Album> albuns;

    // ==========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_artista);

        Intent intent = getIntent();

        Artista artista = (Artista)
                intent.getSerializableExtra(ARTISTA_PARAM);

        this.atribuiElementosDeTela();

        this.populaArtistaEmTela(artista);

        SearchAlbunsDoArtistaTask albunsArtistaTask =
                new SearchAlbunsDoArtistaTask(this);

        albunsArtistaTask.execute(artista.getId().toString());

    }

    private void atribuiElementosDeTela() {
        this.txtvNomeArtista = findViewById(R.id.txtv_artista_nome_artista_imp);
        this.txtvNumeroFans = findViewById(R.id.txtv_artista_numero_fans_imp);
        this.txtvNumeroAlbuns = findViewById(R.id.txtv_artista_numero_albuns_imp);

        this.listViewAlbuns = findViewById(R.id.artista_album_listView);
        this.imgvArtista = findViewById(R.id.artista_image_src);
    }

    private void populaArtistaEmTela(Artista artista) {

        this.txtvNomeArtista.setText(artista.getNome());
        this.txtvNumeroFans.setText("" + artista.getNumeroFans());
        this.txtvNumeroAlbuns.setText(""+artista.getNumeroAlbuns());

        Picasso.with(this)
                .load(artista.getImageUrl())
                .into(this.imgvArtista);

    }

    @Override
    public void onSearchAlbunsDoArtistaSuccess(AlbumListResponse response) {

        final List<Album> albuns = response.getData();
        List<String> nomeDosAlbuns = new ArrayList<>();

        for (Album a : albuns) {
            nomeDosAlbuns.add(a.getNome());
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, nomeDosAlbuns);

        this.listViewAlbuns.setAdapter(arrayAdapter);

    }

    @Override
    public void onSearchAlbunsDoArtistaError(String error) {

    }
}
