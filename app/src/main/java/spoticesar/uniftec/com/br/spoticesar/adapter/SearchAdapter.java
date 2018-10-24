package spoticesar.uniftec.com.br.spoticesar.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;

public class SearchAdapter
        extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Integer> datasource;
    private Context context;

    public SearchAdapter(List<Integer> datasource, Context context) {
        this.context = context;
        this.datasource = datasource;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        LayoutInflater inflater = LayoutInflater
                .from(parent.getContext());

        View itemView = inflater.inflate(R.layout.search_item, parent,
                false);

        return new SearchAdapter.SearchViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(SearchViewHolder viewHolder, int i) {

        viewHolder.populaLista(this.datasource.get(i), this.context);
    }

    @Override
    public int getItemCount() {
        return this.datasource.size();
    }

    public static class SearchViewHolder
            extends RecyclerView.ViewHolder {

        private TextView textView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView
                    .findViewById(R.id.search_item_text_view);
        }

        public void populaLista(Integer i, Context context) {

            this.textView.setText(i.toString());

        }

    }

}
