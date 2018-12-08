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
import spoticesar.uniftec.com.br.spoticesar.models.Musica;
import spoticesar.uniftec.com.br.spoticesar.models.MusicaResponse;
import spoticesar.uniftec.com.br.spoticesar.task.SearchMusicTask;

public class BuscarMusicaActivity
        extends AppCompatActivity implements View.OnClickListener, SearchMusicTask.SearchMusicTaskDelegate {

    private ProgressDialog progressDialog;
    private List<Musica> musicas = new ArrayList<>();
    private Button btnBuscar;
    private EditText edtFiltro;
    private ImageRecyclerViewAdapter<Musica> imageRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_musica);

        this.btnBuscar = findViewById(R.id.btn_buscar_musica);
        this.edtFiltro = findViewById(R.id.edit_buscar_musica);
        this.btnBuscar.setOnClickListener(this);

        RecyclerView listaMusicasRecyclerView =
                this.findViewById(R.id.musica_recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);

        this.imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Musica>(
                        this,
                        this.musicas,
                        DetalheMusicaActivity.MUSICA_PARAM,
                        DetalheMusicaActivity.class
                );

        listaMusicasRecyclerView.setLayoutManager(layoutManager);
        listaMusicasRecyclerView.setAdapter(imageRecyclerViewAdapter);

    }

    @Override
    public void onClick(View v) {
        String filtro = this.edtFiltro.getText().toString();

        if (filtro != null && filtro.trim().length() != 0) {
            progressDialog = ProgressDialog
                    .show(this,
                            "Aguarde",
                            "Buscando Musicas", true, false);
            SearchMusicTask task = new SearchMusicTask(this);
            task.execute(filtro);

        }
    }

    @Override
    public void onSearchMovieSuccess(MusicaResponse response) {
        progressDialog.dismiss();
        progressDialog = null;
        this.imageRecyclerViewAdapter.updateData(response.getData());
    }

    @Override
    public void onSearchMovieError(String error) {

    }

}
