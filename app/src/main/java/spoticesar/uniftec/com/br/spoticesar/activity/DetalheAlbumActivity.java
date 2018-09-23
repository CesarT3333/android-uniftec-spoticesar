package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Album;

public class DetalheAlbumActivity
        extends AppCompatActivity {

    public static final String ALBUM_PARAM = "ALBUM_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);

        Intent intent = this.getIntent();

        Album album = (Album)
                intent.getSerializableExtra(ALBUM_PARAM);

        System.out.println(album);

    }

}
