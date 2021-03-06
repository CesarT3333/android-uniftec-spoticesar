package spoticesar.uniftec.com.br.spoticesar.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.adapter.ImageRecyclerViewAdapter;
import spoticesar.uniftec.com.br.spoticesar.constants.Mock;
import spoticesar.uniftec.com.br.spoticesar.models.Album;
import spoticesar.uniftec.com.br.spoticesar.utils.SearchAdapterListener;

public class BuscaAlbumFragment extends
        Fragment implements SearchAdapterListener {

    private List<Album> albuns;


    public static BuscaAlbumFragment newInstance() {
        BuscaAlbumFragment fragment = new BuscaAlbumFragment();
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_busca_album, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView listaAlbunsRecyclerView =
                view.findViewById(R.id.album_recycler_view);

        this.albuns = Mock.mockAlbuns;

        Context context = this.getContext();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(context);

        ImageRecyclerViewAdapter imageRecyclerViewAdapter =
                new ImageRecyclerViewAdapter<Album>(
                        context,
                        this.albuns,
                        this
                );

        listaAlbunsRecyclerView.setLayoutManager(layoutManager);
        listaAlbunsRecyclerView.setAdapter(imageRecyclerViewAdapter);

    }

    @Override
    public void onSearchItemClick(int position) {

        Fragment childFragment = new DetalheAlbumFragment();

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container_frame_layout, childFragment)
                .commit();

    }

}
