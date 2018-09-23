package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheMusicaActivity
        extends AppCompatActivity {

    // ==========================

    public static final String MUSICA_PARAM = "MUSICA_PARAM";

    // ==========================

    private TextView txtvDuracao;
    private TextView txtvNome;
    private TextView txtvNomeArtista;

    // ==========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);

        Intent intent = getIntent();

        Musica musica = (Musica)
                intent.getSerializableExtra(MUSICA_PARAM);

        this.atribuiElementosDeTela();
        this.populaMusicaEmTela(musica);

    }

    private void populaMusicaEmTela(Musica musica) {
        this.txtvDuracao.setText("04:12");
        this.txtvNome.setText(musica.getNome());
        this.txtvNomeArtista.setText(musica.getArtista().getNome());
    }

    private void atribuiElementosDeTela() {
        this.txtvDuracao = findViewById(R.id.txtv_musica_duracao_imp);
        this.txtvNome = findViewById(R.id.txtv_musica_nome_musica_imp);
        this.txtvNomeArtista = findViewById(R.id.txtv_musica_nome_artista_imp);
    }

}
