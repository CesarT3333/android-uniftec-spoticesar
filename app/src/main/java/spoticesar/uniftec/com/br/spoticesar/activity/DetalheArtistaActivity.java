package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheArtistaActivity extends AppCompatActivity {

    // ==========================

    public static final String ARTISTA_PARAM = "ARTISTA_PARAM";

    // ==========================

    private TextView txtvNomeArtista;
    private ListView listViewAlbuns;

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
        this.populaListaAlbunsEmTela();

    }

    private void populaListaAlbunsEmTela() {
        List<String> musicasToString = this.getNomesAlbuns(this.albuns);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, musicasToString);

        this.listViewAlbuns
                .setAdapter(arrayAdapter);
    }

    private List<String> getNomesAlbuns(List<Album> albuns) {

        List<String> nomesDasMusicas = new ArrayList<>();

        this.albuns = Mock.mockAlbuns;

        for (Album m : this.albuns)
            nomesDasMusicas.add(m.getNome());

        return nomesDasMusicas;

    }

    private void atribuiElementosDeTela() {
        this.txtvNomeArtista = findViewById(R.id.txtv_artista_nome_artista_imp);
        this.listViewAlbuns = findViewById(R.id.artista_album_listView);
    }

    private void populaArtistaEmTela(Artista artista) {
        this.txtvNomeArtista.setText(artista.getNome());
    }

}
