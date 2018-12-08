package spoticesar.uniftec.com.br.spoticesar.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.models.Artista;
import spoticesar.uniftec.com.br.spoticesar.models.ArtistaResponse;
import spoticesar.uniftec.com.br.spoticesar.task.SearchArtistTask;

public class BuscarArtistaActivity
        extends AppCompatActivity
        implements View.OnClickListener,
        SearchArtistTask.SearchArtistTaskDelegate {

    private ImageRecyclerViewAdapter<Artista> imageRecyclerViewAdapter;
    private List<Artista> artistas = new ArrayList<>();
    private ProgressDialog progressDialog;
    private EditText edtFiltro;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_artista);

        this.btnBuscar = findViewById(R.id.btn_buscar_artista);
        this.edtFiltro = findViewById(R.id.edit_buscar_artista);
        this.btnBuscar.setOnClickListener(this);

        RecyclerView listaAlbunsRecyclerView =
                this.findViewById(R.id.artista_recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        this.imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Artista>(
                        this,
                        this.artistas,
                        DetalheArtistaActivity.ARTISTA_PARAM,
                        DetalheArtistaActivity.class
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
                            "Buscando artistas", true, false);
            SearchArtistTask task = new SearchArtistTask(this);
            task.execute(filtro);

        }
    }

    @Override
    public void onSearchMovieSuccess(ArtistaResponse response) {
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
