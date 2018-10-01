package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.activity.DetalheAlbumActivity;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class ImageRecyclerViewAdapter<T extends GenericEntity>
        extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageItemViewHolder>
        implements View.OnClickListener {

    private List<T> entitys;
    private Context context;
    private String activityParam;
    private Class detalheActivity;

    private int positionEntity;

    public ImageRecyclerViewAdapter(
            Context context,
            List<T> entitys,
            String activityParam,
            Class detalheActivity
    ) {
        this.entitys = entitys;
        this.context = context;
        this.activityParam = activityParam;
        this.detalheActivity = detalheActivity;
    }

    @Override
    public ImageItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.entity_menu_item, parent,
                false);

        return new ImageItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ImageItemViewHolder holder, int position) {

        GenericEntity entity =
                this.entitys.get(position);

        this.positionEntity = position;

        holder.parentLayout.setOnClickListener(this);

        holder.populaEntidade(entity);
    }

    @Override
    public int getItemCount() {
        return this.entitys.size();
    }

    @Override
    public void onClick(View v) {

        Intent intent =
                new Intent(context, this.detalheActivity);

        intent.putExtra(this.activityParam,
                entitys.get(this.positionEntity));

        context.startActivity(intent);

    }

    public static class ImageItemViewHolder
            extends RecyclerView.ViewHolder {

        private ImageView imagemAlbum;
        private TextView entityToString;
        LinearLayout parentLayout;

        public ImageItemViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.item_linear_layout);
            imagemAlbum = itemView.findViewById(R.id.image_src);
            entityToString = itemView.findViewById(R.id.entity_to_string);
        }

        public void populaEntidade(GenericEntity entity) {
            this.imagemAlbum.setImageResource(R.drawable.imagi);
            this.entityToString.setText(entity.toString());
        }

    }

}
