package spoticesar.uniftec.com.br.spoticesar.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.SearchAdapter;

public class BlankFragment
        extends Fragment {

    private RecyclerView numberRecyclerView;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        this.numberRecyclerView =
                view.findViewById(R.id.number_recycler_view);

        Context context = this.getContext();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(context);

        SearchAdapter searchAdapter =
                new SearchAdapter(Arrays
                        .asList(3, 4, 1, 5, 3, 2, 1, 3, 5, 2, 4, 3, 2, 8, 6, 5, 4, 3, 1, 6, 5, 4, 8, 7, 2, 8, 3, 7), context);

        numberRecyclerView.setLayoutManager(layoutManager);
        numberRecyclerView.setAdapter(searchAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
