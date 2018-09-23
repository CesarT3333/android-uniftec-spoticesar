package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheArtistaActivity extends AppCompatActivity {

    // ==========================

    public static final String ARTISTA_PARAM = "ARTISTA_PARAM";

    // ==========================

    private TextView txtvNomeArtista;

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

    }

    private void atribuiElementosDeTela() {
        this.txtvNomeArtista = findViewById(R.id.txtv_artista_nome_artista_imp);
    }

    private void populaArtistaEmTela(Artista artista) {
        this.txtvNomeArtista.setText(artista.getNome());
    }

}
