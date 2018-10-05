package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;
import spoticesar.uniftec.com.br.spoticesar.models.Telefone;

public class ImageRecyclerViewAdapter
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageItemViewHolder> {

    private List<Telefone> entitys;
    private Context context;
    private String activityParam;

    private int positionEntity;

    public ImageRecyclerViewAdapter(
            Context context,
            List<Telefone> entitys
    ) {
        this.entitys = entitys;
        this.context = context;
        this.activityParam = activityParam;
    }

    @Override
    public ImageItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_lista_telefonica, parent,
                false);

        return new ImageItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ImageItemViewHolder holder, int position) {

        Telefone tel =
                this.entitys.get(position);

        this.positionEntity = position;

        holder.populaEntidade(tel);

    }

    @Override
    public int getItemCount() {
        return this.entitys.size();
    }

    public static class ImageItemViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtNome;
        private TextView txtEndereco;
        private TextView txtTelefone;

        private LinearLayout parentLayout;

        public ImageItemViewHolder(@NonNull View itemView) {
            super(itemView);

            this.parentLayout = itemView.findViewById(R.id.item_linear_layout);

            this.txtEndereco = itemView.findViewById(R.id.txt_endereco_imp);
            this.txtNome = itemView.findViewById(R.id.txt_nome_impl);
            this.txtTelefone = itemView.findViewById(R.id.txt_telefone_impl);

        }

        public void populaEntidade(Telefone entity) {
            this.txtTelefone.setText(entity.getTelefone());
            this.txtNome.setText(entity.getNome());
            this.txtEndereco.setText(entity.getEndereco());
        }

    }

}
