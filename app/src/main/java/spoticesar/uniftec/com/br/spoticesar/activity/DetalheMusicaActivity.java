package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;

public class DetalheMusicaActivity
        extends AppCompatActivity {

    public static final String MUSICA_PARAM = "MUSICA_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_musica);

        Intent intent = getIntent();

        Musica musica = (Musica)
                intent.getSerializableExtra(MUSICA_PARAM);

    }

}
