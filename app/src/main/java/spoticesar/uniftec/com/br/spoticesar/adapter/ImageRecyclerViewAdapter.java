package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
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
import spoticesar.uniftec.com.br.spoticesar.utils.SearchAdapterListener;

public class ImageRecyclerViewAdapter<T extends GenericEntity>
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageItemViewHolder> {

    private final SearchAdapterListener listener;
    private FragmentActivity detalheFragment;
    private List<T> entitys;
    private Context context;

    private String activityParam;
    private Class detalheActivity;

    private int positionEntity;


    public ImageRecyclerViewAdapter(
            Context context,
            List<T> entitys,
            SearchAdapterListener listener
    ) {
        this.entitys = entitys;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ImageItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.entity_menu_item, parent,
                false);

        return new ImageItemViewHolder(itemView, this.listener);

    }

    @Override
    public void onBindViewHolder(ImageItemViewHolder holder, int position) {
        GenericEntity entity =
                this.entitys.get(position);

        this.positionEntity = position;

        holder.populaEntidade(entity);

    }

    @Override
    public int getItemCount() {
        return this.entitys.size();
    }

    public static class ImageItemViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private ImageView imagemAlbum;
        private TextView entityToString;
        LinearLayout parentLayout;

        SearchAdapterListener holderListener;

        public ImageItemViewHolder(
                @NonNull View itemView,
                SearchAdapterListener listener
        ) {
            super(itemView);

            this.holderListener = listener;

            parentLayout = itemView.findViewById(R.id.item_linear_layout);
            imagemAlbum = itemView.findViewById(R.id.image_src);
            entityToString = itemView.findViewById(R.id.entity_to_string);

            itemView.setOnClickListener(this);

        }

        public void populaEntidade(GenericEntity entity) {

            this.imagemAlbum.setImageResource(R.drawable.imagi);

            this.entityToString.setText(entity.toString());

        }

        @Override
        public void onClick(View view) {
            if (holderListener != null) {
                holderListener.onSearchItemClick(getAdapterPosition());
            }
        }

    }

}
