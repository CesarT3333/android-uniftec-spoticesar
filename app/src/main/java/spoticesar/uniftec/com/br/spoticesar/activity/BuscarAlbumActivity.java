package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageListViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;
import spoticesar.uniftec.com.br.spoticesar.models.Album;

public class BuscarAlbumActivity
        extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Album> albuns = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_album);

        List<GenericEntity> albuns = new ArrayList<>();

        this.albuns = Mock.mockAlbuns;

        albuns.addAll(this.albuns);

        ImageListViewAdapter albumListViewAdapter =
                new ImageListViewAdapter(BuscarAlbumActivity.this, albuns);

        ListView albumListView = this.findViewById(R.id.album_list_view);

        albumListView.setAdapter(albumListViewAdapter);

        albumListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent =
                new Intent(this, DetalheAlbumActivity.class);

        intent.putExtra(DetalheAlbumActivity.ALBUM_PARAM, this.albuns.get(position));

        startActivity(intent);

    }

}
