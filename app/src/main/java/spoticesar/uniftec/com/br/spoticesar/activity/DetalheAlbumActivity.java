package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.utils.MockFilter;

public class DetalheAlbumActivity
        extends AppCompatActivity {

    public static final String ALBUM_PARAM = "ALBUM_PARAM";

    // ======================

    private ListView musicasDoAlbumListView;

    // ======================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);

        Intent intent = this.getIntent();

        Album album = (Album)
                intent.getSerializableExtra(ALBUM_PARAM);

        this.populaAlbumEmTela(album);

        // this.populaMusicasDoAlbum(album.getMusicas());

        this.populaMusicasDoAlbum(
                MockFilter.getMusicasDoAlbum(album.getId()));

    }

    // =======================

    private void populaMusicasDoAlbum(List<Musica> musicas) {

    }

    private void populaAlbumEmTela(Album album) {

    }

}
