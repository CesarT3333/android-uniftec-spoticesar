package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheArtistaActivity extends AppCompatActivity {

    public static final String ARTISTA_PARAM = "ARTISTA_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_artista);

        Intent intent = getIntent();

        Artista artista = (Artista)
                intent.getSerializableExtra(ARTISTA_PARAM);

        System.out.println(artista.toString());

    }

}
