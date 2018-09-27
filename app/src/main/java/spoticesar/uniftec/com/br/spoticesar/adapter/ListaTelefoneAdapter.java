package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Telefone;

public class ListaTelefoneAdapter
        extends RecyclerView.Adapter<ListaTelefoneAdapter.ItemViewHolder> {

    private List<Telefone> telefones =
            new ArrayList<>();

    public ListaTelefoneAdapter(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_lista_telefonica, parent,
                false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Telefone telefone = this.telefones.get(position);
        holder.preencher(telefone);
    }

    @Override
    public int getItemCount() {
        return this.telefones.size();
    }

    public class ItemViewHolder
            extends RecyclerView.ViewHolder {

        private TextView nomeTarefaTextView;
        private TextView tarefaConcluidaTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeTarefaTextView = itemView.findViewById(R.id.nome_tarefa_text_view);
            tarefaConcluidaTextView = itemView.findViewById(R.id.tarefa_concluida_text_view);
        }

        public void preencher(Telefone tarefa) {

            nomeTarefaTextView.setText("teste");
            tarefaConcluidaTextView.setText("OSIDFJOASIDJ");

        }

    }

}
