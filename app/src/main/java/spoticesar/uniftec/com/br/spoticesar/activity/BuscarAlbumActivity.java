package spoticesar.uniftec.com.br.spoticesar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.models.Album;

public class BuscarAlbumActivity
        extends AppCompatActivity
        implements AdapterView.OnItemClickListener, View.OnTouchListener {

    private List<Album> albuns =
            new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_album);

        RecyclerView listaAlbunsRecyclerView =
                this.findViewById(R.id.album_recycler_view);

        this.albuns = Mock.mockAlbuns;

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        ImageRecyclerViewAdapter imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Album>(albuns);

        listaAlbunsRecyclerView.setLayoutManager(layoutManager);
        listaAlbunsRecyclerView.setAdapter(imageRecyclerViewAdapter);

        listaAlbunsRecyclerView.setOnTouchListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =
                new Intent(this, DetalheAlbumActivity.class);

        intent.putExtra(DetalheAlbumActivity.ALBUM_PARAM, this.albuns.get(position));

        startActivity(intent);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
