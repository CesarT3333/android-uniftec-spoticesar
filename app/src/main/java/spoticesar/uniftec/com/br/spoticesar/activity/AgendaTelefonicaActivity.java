package spoticesar.uniftec.com.br.spoticesar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ListaTelefoneAdapter;
import spoticesar.uniftec.com.br.spoticesar.models.Telefone;

public class AgendaTelefonicaActivity extends AppCompatActivity {

    private List<Telefone> telefones;
    private RecyclerView listaTelefonesRecyclerView;
    private ListaTelefoneAdapter listaTelefonesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_telefonica);

        this.listaTelefonesRecyclerView =
                findViewById(R.id.lista_tarefas_recycler_view);

        this.telefones = this.retornaMockTelefones();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaTelefonesRecyclerView.setLayoutManager(layoutManager);

        this.listaTelefonesAdapter = new ListaTelefoneAdapter(this.telefones);

        this.listaTelefonesRecyclerView.setAdapter(this.listaTelefonesAdapter);

    }

    private List<Telefone> retornaMockTelefones() {
        return Arrays.asList(
                new Telefone("nome_1", "telefone_1", "endereco_1"),
                new Telefone("nome_2", "telefone_2", "endereco_2"),
                new Telefone("nome_3", "telefone_3", "endereco_3"),
                new Telefone("nome_4", "telefone_4", "endereco_4"),
                new Telefone("nome_5", "telefone_5", "endereco_5"),
                new Telefone("nome_6", "telefone_6", "endereco_6")
        );

    }

}
