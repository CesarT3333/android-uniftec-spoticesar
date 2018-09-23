package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.generics.GenericEntity;

public class ImageListViewAdapter extends ArrayAdapter<String> {

    Context mContext;
    List<GenericEntity> entitys;

    public ImageListViewAdapter(Context context, List<GenericEntity> entitys) {
        super(context, R.layout.entity_menu_item);

        this.mContext = context;
        this.entitys = entitys;

    }

    @Override
    public int getCount() {
        return this.entitys.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageViewHolder imageViewHolder = new ImageViewHolder();

        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater
                    .inflate(R.layout.entity_menu_item, parent, false);

            imageViewHolder.imageId =
                    convertView.findViewById(R.id.image_src);

            imageViewHolder.entityToString =
                    convertView.findViewById(R.id.entity_to_string);

            convertView.setTag(imageViewHolder);

        } else {

            imageViewHolder = (ImageViewHolder) convertView.getTag();

        }

        final GenericEntity entity =
                this.entitys.get(position);

        imageViewHolder.imageId.setImageResource(entity.getImageId());
        imageViewHolder.entityToString.setText(entity.toString());

        return convertView;

    }

    private static class ImageViewHolder {
        ImageView imageId;
        TextView entityToString;
    }

}