package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class ImageRecyclerViewAdapter<T extends GenericEntity>
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageItemViewHolder> {

    private List<T> entitys;

    public ImageRecyclerViewAdapter(List<T> entitys) {
        this.entitys = entitys;
    }

    @NonNull
    @Override
    public ImageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.entity_menu_item, parent,
                false);

        return new ImageItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageItemViewHolder holder, int position) {
        GenericEntity entity = (GenericEntity)
                this.entitys.get(position);

        holder.populaEntidade(entity);
    }

    @Override
    public int getItemCount() {
        return this.entitys.size();
    }

    public static class ImageItemViewHolder
            extends RecyclerView.ViewHolder {

        private ImageView imagemAlbum;
        private TextView entityToString;

        public ImageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemAlbum = itemView.findViewById(R.id.image_src);
            entityToString = itemView.findViewById(R.id.entity_to_string);
        }

        public void populaEntidade(GenericEntity entity) {
            this.imagemAlbum.setImageResource(R.drawable.imagi);
            this.entityToString.setText(entity.toString());
        }

    }

}
