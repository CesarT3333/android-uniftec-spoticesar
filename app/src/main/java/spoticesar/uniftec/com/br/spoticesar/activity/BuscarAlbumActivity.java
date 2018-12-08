package spoticesar.uniftec.com.br.spoticesar.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.models.AlbumListResponse;
import spoticesar.uniftec.com.br.spoticesar.task.SearchAlbumTask;

public class BuscarAlbumActivity
        extends AppCompatActivity
        implements View.OnClickListener,
        SearchAlbumTask.SearchAlbumTaskDelegate {

    private List<Album> albuns = new ArrayList<>();

    private Button btnBuscar;
    private EditText edtFiltro;
    private ImageRecyclerViewAdapter<Album> imageRecyclerViewAdapter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_buscar_album);

        this.btnBuscar = findViewById(R.id.button_buscar_album);
        this.edtFiltro = findViewById(R.id.edit_buscar_album);

        this.btnBuscar.setOnClickListener(this);
        super.onCreate(savedInstanceState);

        RecyclerView listaAlbunsRecyclerView =
                this.findViewById(R.id.album_recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        this.imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Album>(
                        this,
                        this.albuns,
                        DetalheAlbumActivity.ALBUM_PARAM,
                        DetalheAlbumActivity.class
                );

        listaAlbunsRecyclerView.setLayoutManager(layoutManager);
        listaAlbunsRecyclerView.setAdapter(imageRecyclerViewAdapter);

    }

    @Override
    public void onClick(View v) {
        String filtro = this.edtFiltro.getText().toString();

        if (filtro != null && filtro.trim().length() != 0) {
            progressDialog = ProgressDialog
                    .show(this,
                            "Aguarde",
                            "Buscando Albuns", true, false);
            SearchAlbumTask task = new SearchAlbumTask(this);
            task.execute(filtro);

        }

    }

    @Override
    public void onSearchMovieSuccess(AlbumListResponse response) {
        progressDialog.dismiss();
        progressDialog = null;
        this.imageRecyclerViewAdapter.updateData(response.getData());
    }

    @Override
    public void onSearchMovieError(String error) {
        progressDialog.dismiss();
        progressDialog = null;
        System.out.println(error);
    }

}
